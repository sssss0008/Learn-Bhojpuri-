package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BhojpuriDataSource
import com.example.model.AppLanguage
import com.example.model.Lesson
import com.example.ui.components.VocabularyCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LessonsScreen(
    currentLanguage: AppLanguage,
    selectedLesson: Lesson?,
    completedLessonIds: Set<String>,
    bookmarkedIds: Set<String>,
    masteredIds: Set<String>,
    isSpeaking: Boolean,
    speakingText: String?,
    onSelectLesson: (Lesson) -> Unit,
    onCloseLesson: () -> Unit,
    onCompleteLesson: (String) -> Unit,
    onSpeak: (String, Boolean) -> Unit,
    onToggleBookmark: (String) -> Unit,
    onToggleMastered: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    if (selectedLesson != null) {
        BackHandler {
            onCloseLesson()
        }

        // Detailed Lesson View
        val lessonVocabularies = BhojpuriDataSource.vocabularies.filter {
            selectedLesson.vocabularyIds.contains(it.id)
        }
        val isCompleted = completedLessonIds.contains(selectedLesson.id)

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Column {
                            Text(
                                text = selectedLesson.getTitle(currentLanguage),
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = "${lessonVocabularies.size} ${when (currentLanguage) {
                                    AppLanguage.BHOJPURI -> "शब्द/वाक्य"
                                    AppLanguage.NEPALI -> "शब्द/वाक्यहरू"
                                    AppLanguage.ENGLISH -> "words/phrases"
                                }}",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = onCloseLesson,
                            modifier = Modifier.testTag("back_from_lesson_detail")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        if (!isCompleted) {
                            FilledTonalButton(
                                onClick = { onCompleteLesson(selectedLesson.id) },
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .testTag("mark_lesson_complete_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = null,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = when (currentLanguage) {
                                        AppLanguage.BHOJPURI -> "सम्पन्न"
                                        AppLanguage.NEPALI -> "पूरा भयो"
                                        AppLanguage.ENGLISH -> "Finish"
                                    },
                                    style = MaterialTheme.typography.labelMedium
                                )
                            }
                        } else {
                            Surface(
                                shape = RoundedCornerShape(12.dp),
                                color = MaterialTheme.colorScheme.primaryContainer,
                                modifier = Modifier.padding(end = 12.dp)
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = when (currentLanguage) {
                                            AppLanguage.BHOJPURI -> "पूरा भइल"
                                            AppLanguage.NEPALI -> "सम्पन्न"
                                            AppLanguage.ENGLISH -> "Completed"
                                        },
                                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                            }
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                )
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(top = 10.dp, bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Grammar Tip Card
                item {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(modifier = Modifier.padding(14.dp)) {
                            Text(text = "💡", fontSize = 24.sp)
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = when (currentLanguage) {
                                        AppLanguage.BHOJPURI -> "व्याकरण सूत्र"
                                        AppLanguage.NEPALI -> "व्याकरण सूत्र"
                                        AppLanguage.ENGLISH -> "Grammar Rule"
                                    },
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = selectedLesson.getGrammarTip(currentLanguage),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }
                }

                // Vocabulary Items in this Lesson
                items(lessonVocabularies, key = { it.id }) { item ->
                    VocabularyCard(
                        item = item,
                        currentLanguage = currentLanguage,
                        isBookmarked = bookmarkedIds.contains(item.id),
                        isMastered = masteredIds.contains(item.id),
                        isSpeaking = isSpeaking,
                        speakingText = speakingText,
                        onSpeak = onSpeak,
                        onToggleBookmark = onToggleBookmark,
                        onToggleMastered = onToggleMastered
                    )
                }
            }
        }
    } else {
        // List of All Lessons
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "भोजपुरी पाठ्यक्रम"
                        AppLanguage.NEPALI -> "भोजपुरी पाठ्यक्रम"
                        AppLanguage.ENGLISH -> "Bhojpuri Curriculum"
                    },
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "चरणबद्ध तरीका से बोली अउर व्याकरण सीखीं"
                        AppLanguage.NEPALI -> "चरणबद्ध तरिकाले बोल्न र व्याकरण सिक्नुहोस्"
                        AppLanguage.ENGLISH -> "Step-by-step tracks to master Bhojpuri speech & grammar"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            items(BhojpuriDataSource.lessons, key = { it.id }) { lesson ->
                val isCompleted = completedLessonIds.contains(lesson.id)

                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    border = CardDefaults.outlinedCardBorder(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .clickable { onSelectLesson(lesson) }
                        .testTag("lesson_card_${lesson.id}")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Level / Icon badge
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isCompleted) MaterialTheme.colorScheme.primaryContainer
                                    else MaterialTheme.colorScheme.surfaceVariant
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = lesson.icon, fontSize = 24.sp)
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f),
                                    modifier = Modifier.padding(end = 6.dp)
                                ) {
                                    Text(
                                        text = "${when (currentLanguage) {
                                            AppLanguage.BHOJPURI -> "स्तर"
                                            AppLanguage.NEPALI -> "तह"
                                            AppLanguage.ENGLISH -> "Level"
                                        }} ${lesson.levelNumber}",
                                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }

                                if (isCompleted) {
                                    Icon(
                                        imageVector = Icons.Default.CheckCircle,
                                        contentDescription = "Completed",
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = lesson.getTitle(currentLanguage),
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Text(
                                text = lesson.getDescription(currentLanguage),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 2
                            )
                        }

                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Open Lesson",
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
        }
    }
}
