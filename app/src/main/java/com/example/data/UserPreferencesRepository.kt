package com.example.data

import android.content.Context
import android.content.SharedPreferences
import com.example.model.AppLanguage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Calendar

class UserPreferencesRepository(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("bhojpuri_learner_prefs", Context.MODE_PRIVATE)

    private val _appLanguage = MutableStateFlow(loadLanguage())
    val appLanguage: StateFlow<AppLanguage> = _appLanguage.asStateFlow()

    private val _bookmarkedIds = MutableStateFlow(loadBookmarks())
    val bookmarkedIds: StateFlow<Set<String>> = _bookmarkedIds.asStateFlow()

    private val _masteredIds = MutableStateFlow(loadMastered())
    val masteredIds: StateFlow<Set<String>> = _masteredIds.asStateFlow()

    private val _streakDays = MutableStateFlow(loadStreak())
    val streakDays: StateFlow<Int> = _streakDays.asStateFlow()

    private val _totalXp = MutableStateFlow(prefs.getInt("total_xp", 150))
    val totalXp: StateFlow<Int> = _totalXp.asStateFlow()

    private val _completedLessons = MutableStateFlow(loadCompletedLessons())
    val completedLessons: StateFlow<Set<String>> = _completedLessons.asStateFlow()

    init {
        checkAndUpdateStreak()
    }

    private fun loadLanguage(): AppLanguage {
        val code = prefs.getString("selected_lang", AppLanguage.ENGLISH.code) ?: AppLanguage.ENGLISH.code
        return AppLanguage.entries.find { it.code == code } ?: AppLanguage.ENGLISH
    }

    fun setLanguage(language: AppLanguage) {
        prefs.edit().putString("selected_lang", language.code).apply()
        _appLanguage.value = language
    }

    private fun loadBookmarks(): Set<String> {
        return prefs.getStringSet("bookmarked_ids", setOf("g1", "g3", "fd1")) ?: emptySet()
    }

    fun toggleBookmark(id: String) {
        val current = _bookmarkedIds.value.toMutableSet()
        if (current.contains(id)) {
            current.remove(id)
        } else {
            current.add(id)
        }
        prefs.edit().putStringSet("bookmarked_ids", current).apply()
        _bookmarkedIds.value = current
    }

    private fun loadMastered(): Set<String> {
        return prefs.getStringSet("mastered_ids", setOf("g1", "p1")) ?: emptySet()
    }

    fun setCardMastered(id: String, isMastered: Boolean) {
        val current = _masteredIds.value.toMutableSet()
        if (isMastered) {
            current.add(id)
            addXp(15)
        } else {
            current.remove(id)
        }
        prefs.edit().putStringSet("mastered_ids", current).apply()
        _masteredIds.value = current
    }

    fun addXp(points: Int) {
        val newXp = _totalXp.value + points
        prefs.edit().putInt("total_xp", newXp).apply()
        _totalXp.value = newXp
    }

    private fun loadCompletedLessons(): Set<String> {
        return prefs.getStringSet("completed_lessons", setOf("l1")) ?: emptySet()
    }

    fun markLessonCompleted(lessonId: String) {
        val current = _completedLessons.value.toMutableSet()
        if (!current.contains(lessonId)) {
            current.add(lessonId)
            prefs.edit().putStringSet("completed_lessons", current).apply()
            _completedLessons.value = current
            addXp(50)
        }
    }

    private fun loadStreak(): Int {
        return prefs.getInt("streak_days", 3)
    }

    private fun checkAndUpdateStreak() {
        val today = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        val lastDay = prefs.getInt("last_active_day", -1)

        if (lastDay == -1) {
            prefs.edit().putInt("last_active_day", today).putInt("streak_days", 3).apply()
            _streakDays.value = 3
        } else if (today == lastDay) {
            // Already logged today
        } else if (today - lastDay == 1 || (today == 1 && lastDay >= 365)) {
            val newStreak = _streakDays.value + 1
            prefs.edit().putInt("last_active_day", today).putInt("streak_days", newStreak).apply()
            _streakDays.value = newStreak
            addXp(20)
        } else {
            // Missed a day
            prefs.edit().putInt("last_active_day", today).putInt("streak_days", 1).apply()
            _streakDays.value = 1
        }
    }
}
