package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BhojpuriDataSource
import com.example.model.AppLanguage
import com.example.model.ProverbItem
import com.example.ui.components.AudioButton

@Composable
fun CultureScreen(
    currentLanguage: AppLanguage,
    isSpeaking: Boolean,
    speakingText: String?,
    onSpeak: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabTitles = listOf(
        when (currentLanguage) {
            AppLanguage.BHOJPURI -> "कहावत (Proverbs)"
            AppLanguage.NEPALI -> "उखानहरू (Proverbs)"
            AppLanguage.ENGLISH -> "Proverbs"
        },
        when (currentLanguage) {
            AppLanguage.BHOJPURI -> "धरोहर (Heritage)"
            AppLanguage.NEPALI -> "सांस्कृतिक सम्पदा"
            AppLanguage.ENGLISH -> "Heritage & Culture"
        }
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        // Tab Selector
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = MaterialTheme.colorScheme.surface,
            modifier = Modifier.clip(RoundedCornerShape(14.dp))
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTab == index,
                    onClick = { selectedTab = index },
                    text = {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                            maxLines = 1
                        )
                    },
                    modifier = Modifier.testTag("culture_tab_$index")
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        if (selectedTab == 0) {
            // Proverbs Section
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(bottom = 24.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "लोकप्रिय भोजपुरी कहावत"
                            AppLanguage.NEPALI -> "लोकप्रिय भोजपुरी उखान र टुक्काहरू"
                            AppLanguage.ENGLISH -> "Popular Bhojpuri Proverbs & Wisdom"
                        },
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                items(BhojpuriDataSource.proverbs, key = { it.id }) { proverb ->
                    ProverbCard(
                        proverb = proverb,
                        currentLanguage = currentLanguage,
                        isSpeaking = isSpeaking,
                        speakingText = speakingText,
                        onSpeak = onSpeak
                    )
                }
            }
        } else {
            // Heritage & Cultural Highlights
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(bottom = 24.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "भोजपुरी सभ्यता अउर संस्कार"
                            AppLanguage.NEPALI -> "भोजपुरी सभ्यता, पर्व र इतिहास"
                            AppLanguage.ENGLISH -> "Bhojpuri Civilization & Heritage"
                        },
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                items(BhojpuriDataSource.culturalHighlights) { (title, englishDesc, nepaliDesc) ->
                    Card(
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                        border = CardDefaults.outlinedCardBorder(),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(18.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.primaryContainer),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(text = "🪔", fontSize = 20.sp)
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = title,
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = if (currentLanguage == AppLanguage.ENGLISH) englishDesc else nepaliDesc,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface,
                                lineHeight = 22.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProverbCard(
    proverb: ProverbItem,
    currentLanguage: AppLanguage,
    isSpeaking: Boolean,
    speakingText: String?,
    onSpeak: (String, Boolean) -> Unit
) {
    Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = CardDefaults.outlinedCardBorder(),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("proverb_card_${proverb.id}")
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "📜 \"${proverb.bhojpuri}\"",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 19.sp
                        ),
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = proverb.phonetic,
                        style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
                        color = MaterialTheme.colorScheme.secondary
                    )
                }

                AudioButton(
                    textToSpeak = proverb.bhojpuri,
                    onSpeak = onSpeak,
                    isCurrentlySpeaking = isSpeaking && speakingText == proverb.bhojpuri,
                    size = 40.dp,
                    iconSize = 20.dp
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    // Equivalent in Nepali and English
                    Text(
                        text = "🇳🇵 नेपाली समकक्षी: ${proverb.nepaliEquivalent}",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "🌐 English idiom: ${proverb.englishEquivalent}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = proverb.getExplanation(currentLanguage),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
