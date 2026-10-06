package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.BhojpuriDataSource
import com.example.data.TtsHelper
import com.example.data.UserPreferencesRepository
import com.example.model.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

enum class AppScreen {
    HOME,
    LESSONS,
    PRACTICE,
    ABOUT,
    DICTIONARY,
    CULTURE,
    FLASHCARDS,
    QUIZ,
    CONVERSATIONS,
    GRAMMAR
}

class BhojpuriViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserPreferencesRepository(application)
    private val ttsHelper = TtsHelper(application)

    val appLanguage: StateFlow<AppLanguage> = repository.appLanguage
    val streakDays: StateFlow<Int> = repository.streakDays
    val totalXp: StateFlow<Int> = repository.totalXp
    val bookmarkedIds: StateFlow<Set<String>> = repository.bookmarkedIds
    val masteredIds: StateFlow<Set<String>> = repository.masteredIds
    val completedLessons: StateFlow<Set<String>> = repository.completedLessons

    val isSpeaking: StateFlow<Boolean> = ttsHelper.isSpeaking
    val currentlySpeakingText: StateFlow<String?> = ttsHelper.currentlySpeakingText

    private val _currentScreen = MutableStateFlow(AppScreen.HOME)
    val currentScreen: StateFlow<AppScreen> = _currentScreen.asStateFlow()

    // Selected items for detail sub-views
    private val _selectedLesson = MutableStateFlow<Lesson?>(null)
    val selectedLesson: StateFlow<Lesson?> = _selectedLesson.asStateFlow()

    private val _selectedDialogue = MutableStateFlow<ConversationDialogue?>(null)
    val selectedDialogue: StateFlow<ConversationDialogue?> = _selectedDialogue.asStateFlow()

    // Flashcard State
    private val _flashcardCategory = MutableStateFlow(WordCategory.ALL)
    val flashcardCategory: StateFlow<WordCategory> = _flashcardCategory.asStateFlow()

    private val _currentCardIndex = MutableStateFlow(0)
    val currentCardIndex: StateFlow<Int> = _currentCardIndex.asStateFlow()

    private val _isCardFlipped = MutableStateFlow(false)
    val isCardFlipped: StateFlow<Boolean> = _isCardFlipped.asStateFlow()

    val flashcardDeck: StateFlow<List<VocabularyItem>> = _flashcardCategory.map { category ->
        if (category == WordCategory.ALL) BhojpuriDataSource.vocabularies
        else BhojpuriDataSource.vocabularies.filter { it.category == category }
    }.stateIn(viewModelScope, SharingStarted.Lazily, BhojpuriDataSource.vocabularies)

    // Dictionary search & filter
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _dictCategory = MutableStateFlow(WordCategory.ALL)
    val dictCategory: StateFlow<WordCategory> = _dictCategory.asStateFlow()

    private val _onlyFavorites = MutableStateFlow(false)
    val onlyFavorites: StateFlow<Boolean> = _onlyFavorites.asStateFlow()

    val filteredDictionary: StateFlow<List<VocabularyItem>> = combine(
        _searchQuery,
        _dictCategory,
        _onlyFavorites,
        bookmarkedIds
    ) { query, category, favOnly, favIds ->
        BhojpuriDataSource.vocabularies.filter { item ->
            val matchesCategory = category == WordCategory.ALL || item.category == category
            val matchesFav = !favOnly || favIds.contains(item.id)
            val q = query.trim().lowercase()
            val matchesQuery = q.isEmpty() ||
                    item.bhojpuri.lowercase().contains(q) ||
                    item.phonetic.lowercase().contains(q) ||
                    item.nepali.lowercase().contains(q) ||
                    item.english.lowercase().contains(q) ||
                    item.bhojpuriMeaning.lowercase().contains(q)
            matchesCategory && matchesFav && matchesQuery
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, BhojpuriDataSource.vocabularies)

    // Quiz Engine State
    private val _currentQuizIndex = MutableStateFlow(0)
    val currentQuizIndex: StateFlow<Int> = _currentQuizIndex.asStateFlow()

    private val _selectedOption = MutableStateFlow<String?>(null)
    val selectedOption: StateFlow<String?> = _selectedOption.asStateFlow()

    private val _sentenceBuilderWords = MutableStateFlow<List<String>>(emptyList())
    val sentenceBuilderWords: StateFlow<List<String>> = _sentenceBuilderWords.asStateFlow()

    private val _isQuizChecked = MutableStateFlow(false)
    val isQuizChecked: StateFlow<Boolean> = _isQuizChecked.asStateFlow()

    private val _isQuizCorrect = MutableStateFlow(false)
    val isQuizCorrect: StateFlow<Boolean> = _isQuizCorrect.asStateFlow()

    private val _quizScore = MutableStateFlow(0)
    val quizScore: StateFlow<Int> = _quizScore.asStateFlow()

    private val _isQuizFinished = MutableStateFlow(false)
    val isQuizFinished: StateFlow<Boolean> = _isQuizFinished.asStateFlow()

    private val _practiceSubTab = MutableStateFlow(0)
    val practiceSubTab: StateFlow<Int> = _practiceSubTab.asStateFlow()

    fun setPracticeSubTab(index: Int) {
        _practiceSubTab.value = index
    }

    val allQuizzes: List<QuizItem> = BhojpuriDataSource.quizzes

    val wordOfTheDay: VocabularyItem = BhojpuriDataSource.vocabularies.firstOrNull { it.id == "g3" }
        ?: BhojpuriDataSource.vocabularies.first()

    // Navigation methods
    fun navigateTo(screen: AppScreen) {
        _currentScreen.value = screen
        if (screen != AppScreen.LESSONS) _selectedLesson.value = null
        if (screen != AppScreen.CONVERSATIONS) _selectedDialogue.value = null
    }

    fun openLesson(lesson: Lesson) {
        _selectedLesson.value = lesson
        _currentScreen.value = AppScreen.LESSONS
    }

    fun closeLesson() {
        _selectedLesson.value = null
    }

    fun openDialogue(dialogue: ConversationDialogue) {
        _selectedDialogue.value = dialogue
        _currentScreen.value = AppScreen.CONVERSATIONS
    }

    fun closeDialogue() {
        _selectedDialogue.value = null
    }

    // Language setting
    fun setAppLanguage(lang: AppLanguage) {
        repository.setLanguage(lang)
    }

    // Audio methods
    fun speakBhojpuri(text: String, isSlow: Boolean = false) {
        ttsHelper.speak(text, isSlow)
    }

    fun stopAudio() {
        ttsHelper.stop()
    }

    // Bookmarks and Progress
    fun toggleBookmark(id: String) {
        repository.toggleBookmark(id)
    }

    fun toggleMastered(id: String) {
        val currentMastered = repository.masteredIds.value.contains(id)
        repository.setCardMastered(id, !currentMastered)
    }

    fun markCurrentLessonCompleted(lessonId: String) {
        repository.markLessonCompleted(lessonId)
    }

    // Flashcard Actions
    fun setFlashcardCategory(category: WordCategory) {
        _flashcardCategory.value = category
        _currentCardIndex.value = 0
        _isCardFlipped.value = false
    }

    fun flipCard() {
        _isCardFlipped.value = !_isCardFlipped.value
    }

    fun nextCard() {
        val deckSize = flashcardDeck.value.size
        if (deckSize > 0) {
            _currentCardIndex.value = (_currentCardIndex.value + 1) % deckSize
            _isCardFlipped.value = false
        }
    }

    fun previousCard() {
        val deckSize = flashcardDeck.value.size
        if (deckSize > 0) {
            _currentCardIndex.value = if (_currentCardIndex.value - 1 < 0) deckSize - 1 else _currentCardIndex.value - 1
            _isCardFlipped.value = false
        }
    }

    fun markCardMasteredAndNext(id: String) {
        repository.setCardMastered(id, true)
        nextCard()
    }

    // Dictionary actions
    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setDictionaryCategory(category: WordCategory) {
        _dictCategory.value = category
    }

    fun toggleOnlyFavorites() {
        _onlyFavorites.value = !_onlyFavorites.value
    }

    // Quiz Actions
    fun selectQuizOption(option: String) {
        if (!_isQuizChecked.value) {
            _selectedOption.value = option
        }
    }

    fun addSentenceWord(word: String) {
        if (!_isQuizChecked.value) {
            _sentenceBuilderWords.value = _sentenceBuilderWords.value + word
        }
    }

    fun removeSentenceWord(index: Int) {
        if (!_isQuizChecked.value) {
            val list = _sentenceBuilderWords.value.toMutableList()
            if (index in list.indices) {
                list.removeAt(index)
                _sentenceBuilderWords.value = list
            }
        }
    }

    fun checkAnswer() {
        val currentQuiz = allQuizzes.getOrNull(_currentQuizIndex.value) ?: return
        val isCorrect = when (currentQuiz.type) {
            QuizType.MULTIPLE_CHOICE, QuizType.LISTENING -> {
                _selectedOption.value == currentQuiz.correctAnswer
            }
            QuizType.SENTENCE_BUILDER -> {
                val constructed = _sentenceBuilderWords.value.joinToString(" ")
                constructed.trim() == currentQuiz.correctAnswer.trim()
            }
        }
        _isQuizCorrect.value = isCorrect
        _isQuizChecked.value = true
        if (isCorrect) {
            _quizScore.value += 1
            repository.addXp(25)
        }
    }

    fun nextQuizQuestion() {
        if (_currentQuizIndex.value + 1 < allQuizzes.size) {
            _currentQuizIndex.value += 1
            _selectedOption.value = null
            _sentenceBuilderWords.value = emptyList()
            _isQuizChecked.value = false
            _isQuizCorrect.value = false
        } else {
            _isQuizFinished.value = true
        }
    }

    fun restartQuiz() {
        _currentQuizIndex.value = 0
        _selectedOption.value = null
        _sentenceBuilderWords.value = emptyList()
        _isQuizChecked.value = false
        _isQuizCorrect.value = false
        _quizScore.value = 0
        _isQuizFinished.value = false
    }

    override fun onCleared() {
        super.onCleared()
        ttsHelper.shutdown()
    }
}
