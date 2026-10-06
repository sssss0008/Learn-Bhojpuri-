package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BhojpuriDataSource
import com.example.model.AppLanguage
import com.example.model.UiStrings
import com.example.model.VocabularyItem
import com.example.ui.components.AudioButton
import com.example.viewmodel.AppScreen

@Composable
fun HomeScreen(
    currentLanguage: AppLanguage,
    streakDays: Int,
    totalXp: Int,
    masteredCount: Int,
    completedLessonsCount: Int,
    wordOfTheDay: VocabularyItem,
    isSpeaking: Boolean,
    speakingText: String?,
    onSpeak: (String, Boolean) -> Unit,
    onNavigate: (AppScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Welcome Hero Banner
        item {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("hero_banner")
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    MaterialTheme.colorScheme.primary,
                                    Color(0xFFC2410C),
                                    Color(0xFF9A3412)
                                )
                            )
                        )
                        .padding(20.dp)
                ) {
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "🌾", fontSize = 28.sp)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = when (currentLanguage) {
                                    AppLanguage.BHOJPURI -> "सुस्वागतम्! भोजपुरी सीखल जाव"
                                    AppLanguage.NEPALI -> "हार्दिक स्वागत छ! भोजपुरी सिकौँ"
                                    AppLanguage.ENGLISH -> "Welcome! Let's Learn Bhojpuri"
                                },
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                ),
                                color = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = when (currentLanguage) {
                                AppLanguage.BHOJPURI -> "नेपाल के तराई अउर पूर्वांचल के मिठास, संस्कार अउर लोक संस्कृति अब रउआ मुठ्ठी में।"
                                AppLanguage.NEPALI -> "नेपालको तराई र पूर्वाञ्चलको मिठास, संस्कार र लोक संस्कृति अब तपाईंको हातमा।"
                                AppLanguage.ENGLISH -> "Discover the melodious tongue of Nepal's Terai and Purvanchal with authentic audio & lessons."
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color(0xFFFFEBDD),
                            lineHeight = 20.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Quick action button on banner
                        FilledTonalButton(
                            onClick = { onNavigate(AppScreen.LESSONS) },
                            colors = ButtonDefaults.filledTonalButtonColors(
                                containerColor = Color.White,
                                contentColor = MaterialTheme.colorScheme.primary
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.testTag("start_learning_button")
                        ) {
                            Icon(
                                imageVector = Icons.Default.MenuBook,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = when (currentLanguage) {
                                    AppLanguage.BHOJPURI -> "सुरू करीं"
                                    AppLanguage.NEPALI -> "सिक्न सुरु गर्नुहोस्"
                                    AppLanguage.ENGLISH -> "Start Lessons"
                                },
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        // Stats Dashboard
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatCard(
                    icon = Icons.Default.LocalFireDepartment,
                    iconColor = MaterialTheme.colorScheme.primary,
                    value = "$streakDays",
                    label = UiStrings.dailyStreak(currentLanguage),
                    modifier = Modifier.weight(1f)
                )
                StatCard(
                    icon = Icons.Default.Stars,
                    iconColor = MaterialTheme.colorScheme.tertiary,
                    value = "$totalXp",
                    label = UiStrings.xpPoints(currentLanguage),
                    modifier = Modifier.weight(1f)
                )
                StatCard(
                    icon = Icons.Default.CheckCircle,
                    iconColor = MaterialTheme.colorScheme.secondary,
                    value = "$masteredCount",
                    label = UiStrings.mastered(currentLanguage),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Word of the Day (आज के शब्द)
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                border = CardDefaults.outlinedCardBorder(),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("word_of_the_day_card")
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            color = MaterialTheme.colorScheme.primaryContainer,
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Text(
                                text = "⭐ ${UiStrings.wordOfTheDay(currentLanguage)}",
                                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        AudioButton(
                            textToSpeak = wordOfTheDay.bhojpuri,
                            onSpeak = onSpeak,
                            isCurrentlySpeaking = isSpeaking && speakingText == wordOfTheDay.bhojpuri
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = wordOfTheDay.bhojpuri,
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )

                    Text(
                        text = wordOfTheDay.phonetic,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontStyle = FontStyle.Italic
                        ),
                        color = MaterialTheme.colorScheme.secondary
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(10.dp)) {
                            Text(
                                text = wordOfTheDay.getMeaning(currentLanguage),
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            if (currentLanguage != AppLanguage.NEPALI) {
                                Text(
                                    text = "नेपाली: ${wordOfTheDay.nepali}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            if (currentLanguage != AppLanguage.ENGLISH) {
                                Text(
                                    text = "English: ${wordOfTheDay.english}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    if (wordOfTheDay.exampleBhojpuri.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "💡 ${wordOfTheDay.exampleBhojpuri} (${wordOfTheDay.examplePhonetic})",
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Medium),
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
        }

        // Quick Navigation Grid
        item {
            Text(
                text = when (currentLanguage) {
                    AppLanguage.BHOJPURI -> "सीखे के साधन"
                    AppLanguage.NEPALI -> "सिक्ने माध्यमहरू"
                    AppLanguage.ENGLISH -> "Learning Modules"
                },
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                QuickActionCard(
                    title = UiStrings.lessonsTab(currentLanguage),
                    subtitle = "8 ${when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "पाठ"
                        AppLanguage.NEPALI -> "पाठहरू"
                        AppLanguage.ENGLISH -> "Lessons"
                    }}",
                    icon = Icons.Default.MenuBook,
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    iconTint = MaterialTheme.colorScheme.primary,
                    onClick = { onNavigate(AppScreen.LESSONS) },
                    modifier = Modifier.weight(1f)
                )

                QuickActionCard(
                    title = UiStrings.flashcards(currentLanguage),
                    subtitle = when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "पलट के सीखीं"
                        AppLanguage.NEPALI -> "दोहोर्याउनुहोस्"
                        AppLanguage.ENGLISH -> "Smart Cards"
                    },
                    icon = Icons.Default.Style,
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    iconTint = MaterialTheme.colorScheme.secondary,
                    onClick = { onNavigate(AppScreen.FLASHCARDS) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                QuickActionCard(
                    title = UiStrings.takeQuiz(currentLanguage),
                    subtitle = when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "जांच अउर अंक"
                        AppLanguage.NEPALI -> "क्विज अभ्यास"
                        AppLanguage.ENGLISH -> "Fun Quizzes"
                    },
                    icon = Icons.Default.Quiz,
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                    iconTint = MaterialTheme.colorScheme.tertiary,
                    onClick = { onNavigate(AppScreen.QUIZ) },
                    modifier = Modifier.weight(1f)
                )

                QuickActionCard(
                    title = UiStrings.conversations(currentLanguage),
                    subtitle = when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "बोलचाल संवाद"
                        AppLanguage.NEPALI -> "दैनिक संवाद"
                        AppLanguage.ENGLISH -> "Dialogues"
                    },
                    icon = Icons.Default.Forum,
                    containerColor = Color(0xFFE0F2FE),
                    iconTint = Color(0xFF0369A1),
                    onClick = { onNavigate(AppScreen.CONVERSATIONS) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                QuickActionCard(
                    title = UiStrings.grammarGuide(currentLanguage),
                    subtitle = when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "नियम अउर आदर"
                        AppLanguage.NEPALI -> "व्याकरण नियम"
                        AppLanguage.ENGLISH -> "Honorifics & Rules"
                    },
                    icon = Icons.Default.AutoStories,
                    containerColor = Color(0xFFF3E8FF),
                    iconTint = Color(0xFF7E22CE),
                    onClick = { onNavigate(AppScreen.GRAMMAR) },
                    modifier = Modifier.weight(1f)
                )

                QuickActionCard(
                    title = UiStrings.cultureTab(currentLanguage),
                    subtitle = when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "कहावत अउर पर्व"
                        AppLanguage.NEPALI -> "उखान र पर्व"
                        AppLanguage.ENGLISH -> "Heritage & Sayings"
                    },
                    icon = Icons.Default.Festival,
                    containerColor = Color(0xFFFEF3C7),
                    iconTint = Color(0xFFB45309),
                    onClick = { onNavigate(AppScreen.CULTURE) },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        // Cultural spotlight snippet
        item {
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "🎭", fontSize = 32.sp)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = when (currentLanguage) {
                                AppLanguage.BHOJPURI -> "भोजपुरी के मिठास"
                                AppLanguage.NEPALI -> "भोजपुरी भाषाको मिठास"
                                AppLanguage.ENGLISH -> "The Sweetness of Bhojpuri"
                            },
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = when (currentLanguage) {
                                AppLanguage.BHOJPURI -> "'रउआ' कह के बात करे में जवन आदर आ प्रेम मिलेला, ऊ भोजपुरी के खास पहचान हवे।"
                                AppLanguage.NEPALI -> "'रउआ' भनी गरिने आदर र मिठास नै भोजपुरी संस्कृतिको मौलिक पहिचान हो।"
                                AppLanguage.ENGLISH -> "Addressing someone with 'Rauaa' expresses heartfelt respect and familial warmth."
                            },
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun StatCard(
    icon: ImageVector,
    iconColor: Color,
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        border = CardDefaults.outlinedCardBorder(),
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1
            )
        }
    }
}

@Composable
private fun QuickActionCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    containerColor: Color,
    iconTint: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = CardDefaults.outlinedCardBorder(),
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .clickable(onClick = onClick)
            .testTag("action_${title.take(8)}")
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(containerColor),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = iconTint,
                    modifier = Modifier.size(22.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
