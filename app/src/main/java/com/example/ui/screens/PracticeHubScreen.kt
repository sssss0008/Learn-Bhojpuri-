package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.model.*
import com.example.viewmodel.BhojpuriViewModel

@Composable
fun PracticeHubScreen(
    currentLanguage: AppLanguage,
    activeSubTab: Int,
    onTabSelected: (Int) -> Unit,
    viewModel: BhojpuriViewModel,
    modifier: Modifier = Modifier
) {
    val tabTitles = listOf(
        Triple(UiStrings.flashcards(currentLanguage), "🎴", "tab_flashcards"),
        Triple(UiStrings.takeQuiz(currentLanguage), "🎯", "tab_quiz"),
        Triple(UiStrings.conversations(currentLanguage), "💬", "tab_dialogues"),
        Triple(UiStrings.grammarGuide(currentLanguage), "⚖️", "tab_grammar"),
        Triple(UiStrings.proverbs(currentLanguage), "📜", "tab_proverbs")
    )

    Column(modifier = modifier.fillMaxSize()) {
        // Sub-tabs scrollable row
        ScrollableTabRow(
            selectedTabIndex = activeSubTab,
            containerColor = MaterialTheme.colorScheme.surface,
            edgePadding = 16.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {
            tabTitles.forEachIndexed { index, (title, icon, tag) ->
                Tab(
                    selected = activeSubTab == index,
                    onClick = { onTabSelected(index) },
                    text = {
                        Text(
                            text = "$icon $title",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = if (activeSubTab == index) FontWeight.Bold else FontWeight.Medium
                            ),
                            maxLines = 1
                        )
                    },
                    modifier = Modifier.testTag(tag)
                )
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            when (activeSubTab) {
                0 -> {
                    // Flashcards
                    val deck by viewModel.flashcardDeck.collectAsState()
                    val currentIndex by viewModel.currentCardIndex.collectAsState()
                    val isFlipped by viewModel.isCardFlipped.collectAsState()
                    val category by viewModel.flashcardCategory.collectAsState()
                    val masteredIds by viewModel.masteredIds.collectAsState()
                    val isSpeaking by viewModel.isSpeaking.collectAsState()
                    val speakingText by viewModel.currentlySpeakingText.collectAsState()

                    FlashcardsScreen(
                        currentLanguage = currentLanguage,
                        deck = deck,
                        currentIndex = currentIndex,
                        isFlipped = isFlipped,
                        selectedCategory = category,
                        masteredIds = masteredIds,
                        isSpeaking = isSpeaking,
                        speakingText = speakingText,
                        onCategorySelected = { viewModel.setFlashcardCategory(it) },
                        onFlip = { viewModel.flipCard() },
                        onNext = { viewModel.nextCard() },
                        onPrevious = { viewModel.previousCard() },
                        onMarkMastered = { viewModel.markCardMasteredAndNext(it) },
                        onSpeak = { text, isSlow -> viewModel.speakBhojpuri(text, isSlow) }
                    )
                }

                1 -> {
                    // Quizzes
                    val currentQuizIndex by viewModel.currentQuizIndex.collectAsState()
                    val selectedOption by viewModel.selectedOption.collectAsState()
                    val sentenceWords by viewModel.sentenceBuilderWords.collectAsState()
                    val isChecked by viewModel.isQuizChecked.collectAsState()
                    val isCorrect by viewModel.isQuizCorrect.collectAsState()
                    val quizScore by viewModel.quizScore.collectAsState()
                    val isFinished by viewModel.isQuizFinished.collectAsState()
                    val isSpeaking by viewModel.isSpeaking.collectAsState()
                    val speakingText by viewModel.currentlySpeakingText.collectAsState()

                    QuizScreen(
                        currentLanguage = currentLanguage,
                        quizzes = viewModel.allQuizzes,
                        currentIndex = currentQuizIndex,
                        selectedOption = selectedOption,
                        sentenceWords = sentenceWords,
                        isChecked = isChecked,
                        isCorrect = isCorrect,
                        score = quizScore,
                        isFinished = isFinished,
                        isSpeaking = isSpeaking,
                        speakingText = speakingText,
                        onSelectOption = { viewModel.selectQuizOption(it) },
                        onAddSentenceWord = { viewModel.addSentenceWord(it) },
                        onRemoveSentenceWord = { viewModel.removeSentenceWord(it) },
                        onCheckAnswer = { viewModel.checkAnswer() },
                        onNextQuestion = { viewModel.nextQuizQuestion() },
                        onRestartQuiz = { viewModel.restartQuiz() },
                        onSpeak = { text, isSlow -> viewModel.speakBhojpuri(text, isSlow) }
                    )
                }

                2 -> {
                    // Conversations
                    val selectedDialogue by viewModel.selectedDialogue.collectAsState()
                    val isSpeaking by viewModel.isSpeaking.collectAsState()
                    val speakingText by viewModel.currentlySpeakingText.collectAsState()

                    ConversationScreen(
                        currentLanguage = currentLanguage,
                        selectedDialogue = selectedDialogue,
                        isSpeaking = isSpeaking,
                        speakingText = speakingText,
                        onSelectDialogue = { viewModel.openDialogue(it) },
                        onCloseDialogue = { viewModel.closeDialogue() },
                        onSpeak = { text, isSlow -> viewModel.speakBhojpuri(text, isSlow) }
                    )
                }

                3 -> {
                    // Grammar Guide
                    val isSpeaking by viewModel.isSpeaking.collectAsState()
                    val speakingText by viewModel.currentlySpeakingText.collectAsState()

                    GrammarScreen(
                        currentLanguage = currentLanguage,
                        isSpeaking = isSpeaking,
                        speakingText = speakingText,
                        onSpeak = { text, isSlow -> viewModel.speakBhojpuri(text, isSlow) }
                    )
                }

                4 -> {
                    // Proverbs & Heritage
                    val isSpeaking by viewModel.isSpeaking.collectAsState()
                    val speakingText by viewModel.currentlySpeakingText.collectAsState()

                    CultureScreen(
                        currentLanguage = currentLanguage,
                        isSpeaking = isSpeaking,
                        speakingText = speakingText,
                        onSpeak = { text, isSlow -> viewModel.speakBhojpuri(text, isSlow) }
                    )
                }
            }
        }
    }
}
