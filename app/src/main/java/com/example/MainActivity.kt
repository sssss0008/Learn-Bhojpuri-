package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.model.AppLanguage
import com.example.model.UiStrings
import com.example.ui.components.AppDrawerContent
import com.example.ui.components.BhojpuriTopBar
import com.example.ui.screens.*
import com.example.ui.theme.BhojpuriBhasaTheme
import com.example.viewmodel.AppScreen
import com.example.viewmodel.BhojpuriViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BhojpuriBhasaTheme {
                BhojpuriApp()
            }
        }
    }
}

data class NavigationTabItem(
    val screen: AppScreen,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val labelProvider: (AppLanguage) -> String,
    val testTag: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BhojpuriApp(viewModel: BhojpuriViewModel = viewModel()) {
    val currentScreen by viewModel.currentScreen.collectAsStateWithLifecycle()
    val appLanguage by viewModel.appLanguage.collectAsStateWithLifecycle()
    val streakDays by viewModel.streakDays.collectAsStateWithLifecycle()
    val totalXp by viewModel.totalXp.collectAsStateWithLifecycle()
    val bookmarkedIds by viewModel.bookmarkedIds.collectAsStateWithLifecycle()
    val masteredIds by viewModel.masteredIds.collectAsStateWithLifecycle()
    val completedLessons by viewModel.completedLessons.collectAsStateWithLifecycle()

    val isSpeaking by viewModel.isSpeaking.collectAsStateWithLifecycle()
    val speakingText by viewModel.currentlySpeakingText.collectAsStateWithLifecycle()

    val selectedLesson by viewModel.selectedLesson.collectAsStateWithLifecycle()
    val selectedDialogue by viewModel.selectedDialogue.collectAsStateWithLifecycle()
    val practiceSubTab by viewModel.practiceSubTab.collectAsStateWithLifecycle()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    // Back handling
    BackHandler(enabled = drawerState.isOpen) {
        coroutineScope.launch { drawerState.close() }
    }

    BackHandler(
        enabled = !drawerState.isOpen && currentScreen != AppScreen.HOME && selectedLesson == null && selectedDialogue == null
    ) {
        viewModel.navigateTo(AppScreen.HOME)
    }

    // Exactly 4 Primary Navigation Tabs: Home, Learn, Practice, About
    val navigationTabs = listOf(
        NavigationTabItem(
            screen = AppScreen.HOME,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            labelProvider = { UiStrings.homeTab(it) },
            testTag = "nav_tab_home"
        ),
        NavigationTabItem(
            screen = AppScreen.LESSONS,
            selectedIcon = Icons.Filled.MenuBook,
            unselectedIcon = Icons.Outlined.MenuBook,
            labelProvider = { UiStrings.learnTab(it) },
            testTag = "nav_tab_learn"
        ),
        NavigationTabItem(
            screen = AppScreen.PRACTICE,
            selectedIcon = Icons.Filled.Quiz,
            unselectedIcon = Icons.Outlined.Quiz,
            labelProvider = { UiStrings.practiceTab(it) },
            testTag = "nav_tab_practice"
        ),
        NavigationTabItem(
            screen = AppScreen.ABOUT,
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
            labelProvider = { UiStrings.aboutTab(it) },
            testTag = "nav_tab_about"
        )
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawerContent(
                currentLanguage = appLanguage,
                currentScreen = currentScreen,
                streakDays = streakDays,
                totalXp = totalXp,
                onNavigate = { screen ->
                    viewModel.navigateTo(screen)
                    coroutineScope.launch { drawerState.close() }
                },
                onOpenPracticeSubTab = { tabIndex ->
                    viewModel.setPracticeSubTab(tabIndex)
                    viewModel.navigateTo(AppScreen.PRACTICE)
                    coroutineScope.launch { drawerState.close() }
                },
                onLanguageSelected = { viewModel.setAppLanguage(it) },
                onCloseDrawer = { coroutineScope.launch { drawerState.close() } }
            )
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                if (selectedLesson == null && selectedDialogue == null) {
                    BhojpuriTopBar(
                        currentLanguage = appLanguage,
                        onLanguageSelected = { viewModel.setAppLanguage(it) },
                        streakDays = streakDays,
                        totalXp = totalXp,
                        onOpenDrawer = { coroutineScope.launch { drawerState.open() } }
                    )
                }
            },
            bottomBar = {
                if (selectedLesson == null && selectedDialogue == null) {
                    NavigationBar(
                        modifier = Modifier
                            .windowInsetsPadding(WindowInsets.navigationBars)
                            .testTag("main_navigation_bar"),
                        containerColor = MaterialTheme.colorScheme.surface
                    ) {
                        navigationTabs.forEach { tab ->
                            val isSelected = currentScreen == tab.screen ||
                                    (tab.screen == AppScreen.PRACTICE &&
                                            (currentScreen == AppScreen.FLASHCARDS || currentScreen == AppScreen.QUIZ || currentScreen == AppScreen.CONVERSATIONS || currentScreen == AppScreen.GRAMMAR))
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = { viewModel.navigateTo(tab.screen) },
                                icon = {
                                    Icon(
                                        imageVector = if (isSelected) tab.selectedIcon else tab.unselectedIcon,
                                        contentDescription = tab.labelProvider(appLanguage)
                                    )
                                },
                                label = {
                                    Text(
                                        text = tab.labelProvider(appLanguage),
                                        style = MaterialTheme.typography.labelSmall,
                                        maxLines = 1
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                                    selectedIconColor = MaterialTheme.colorScheme.primary,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                                ),
                                modifier = Modifier.testTag(tab.testTag)
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(innerPadding)
            ) {
                when (currentScreen) {
                    AppScreen.HOME -> {
                        HomeScreen(
                            currentLanguage = appLanguage,
                            streakDays = streakDays,
                            totalXp = totalXp,
                            masteredCount = masteredIds.size,
                            completedLessonsCount = completedLessons.size,
                            wordOfTheDay = viewModel.wordOfTheDay,
                            isSpeaking = isSpeaking,
                            speakingText = speakingText,
                            onSpeak = { text, isSlow -> viewModel.speakBhojpuri(text, isSlow) },
                            onNavigate = { screen ->
                                when (screen) {
                                    AppScreen.FLASHCARDS -> {
                                        viewModel.setPracticeSubTab(0)
                                        viewModel.navigateTo(AppScreen.PRACTICE)
                                    }
                                    AppScreen.QUIZ -> {
                                        viewModel.setPracticeSubTab(1)
                                        viewModel.navigateTo(AppScreen.PRACTICE)
                                    }
                                    AppScreen.CONVERSATIONS -> {
                                        viewModel.setPracticeSubTab(2)
                                        viewModel.navigateTo(AppScreen.PRACTICE)
                                    }
                                    AppScreen.GRAMMAR -> {
                                        viewModel.setPracticeSubTab(3)
                                        viewModel.navigateTo(AppScreen.PRACTICE)
                                    }
                                    else -> viewModel.navigateTo(screen)
                                }
                            }
                        )
                    }

                    AppScreen.LESSONS -> {
                        LessonsScreen(
                            currentLanguage = appLanguage,
                            selectedLesson = selectedLesson,
                            completedLessonIds = completedLessons,
                            bookmarkedIds = bookmarkedIds,
                            masteredIds = masteredIds,
                            isSpeaking = isSpeaking,
                            speakingText = speakingText,
                            onSelectLesson = { viewModel.openLesson(it) },
                            onCloseLesson = { viewModel.closeLesson() },
                            onCompleteLesson = { viewModel.markCurrentLessonCompleted(it) },
                            onSpeak = { text, isSlow -> viewModel.speakBhojpuri(text, isSlow) },
                            onToggleBookmark = { viewModel.toggleBookmark(it) },
                            onToggleMastered = { viewModel.toggleMastered(it) }
                        )
                    }

                    AppScreen.PRACTICE, AppScreen.FLASHCARDS, AppScreen.QUIZ, AppScreen.CONVERSATIONS, AppScreen.GRAMMAR -> {
                        PracticeHubScreen(
                            currentLanguage = appLanguage,
                            activeSubTab = practiceSubTab,
                            onTabSelected = { viewModel.setPracticeSubTab(it) },
                            viewModel = viewModel
                        )
                    }

                    AppScreen.ABOUT -> {
                        AboutScreen(
                            currentLanguage = appLanguage
                        )
                    }

                    AppScreen.DICTIONARY -> {
                        val filteredDictionary by viewModel.filteredDictionary.collectAsStateWithLifecycle()
                        val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()
                        val dictCategory by viewModel.dictCategory.collectAsStateWithLifecycle()
                        val onlyFavorites by viewModel.onlyFavorites.collectAsStateWithLifecycle()

                        DictionaryScreen(
                            currentLanguage = appLanguage,
                            vocabularies = filteredDictionary,
                            searchQuery = searchQuery,
                            selectedCategory = dictCategory,
                            onlyFavorites = onlyFavorites,
                            bookmarkedIds = bookmarkedIds,
                            masteredIds = masteredIds,
                            isSpeaking = isSpeaking,
                            speakingText = speakingText,
                            onSearchChange = { viewModel.setSearchQuery(it) },
                            onCategorySelected = { viewModel.setDictionaryCategory(it) },
                            onToggleFavorites = { viewModel.toggleOnlyFavorites() },
                            onSpeak = { text, isSlow -> viewModel.speakBhojpuri(text, isSlow) },
                            onToggleBookmark = { viewModel.toggleBookmark(it) },
                            onToggleMastered = { viewModel.toggleMastered(it) }
                        )
                    }

                    AppScreen.CULTURE -> {
                        CultureScreen(
                            currentLanguage = appLanguage,
                            isSpeaking = isSpeaking,
                            speakingText = speakingText,
                            onSpeak = { text, isSlow -> viewModel.speakBhojpuri(text, isSlow) }
                        )
                    }
                }
            }
        }
    }
}
