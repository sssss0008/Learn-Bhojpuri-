package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import com.example.model.GrammarTopic
import com.example.ui.components.AudioButton

@Composable
fun GrammarScreen(
    currentLanguage: AppLanguage,
    isSpeaking: Boolean,
    speakingText: String?,
    onSpeak: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = when (currentLanguage) {
                    AppLanguage.BHOJPURI -> "भोजपुरी व्याकरण अउर नियम"
                    AppLanguage.NEPALI -> "भोजपुरी व्याकरण र नियमहरू"
                    AppLanguage.ENGLISH -> "Bhojpuri Grammar & Rules"
                },
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = when (currentLanguage) {
                    AppLanguage.BHOJPURI -> "आदर, काल अउर प्रत्यय के सही प्रयोग सीखीं"
                    AppLanguage.NEPALI -> "आदरार्थी तह, काल र प्रत्ययको सही प्रयोग सिक्नुहोस्"
                    AppLanguage.ENGLISH -> "Understand honorifics, tense markers, and expressive suffixes"
                },
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        items(BhojpuriDataSource.grammarTopics, key = { it.id }) { topic ->
            GrammarTopicCard(
                topic = topic,
                currentLanguage = currentLanguage,
                isSpeaking = isSpeaking,
                speakingText = speakingText,
                onSpeak = onSpeak
            )
        }
    }
}

@Composable
private fun GrammarTopicCard(
    topic: GrammarTopic,
    currentLanguage: AppLanguage,
    isSpeaking: Boolean,
    speakingText: String?,
    onSpeak: (String, Boolean) -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        border = CardDefaults.outlinedCardBorder(),
        modifier = Modifier
            .fillMaxWidth()
            .testTag("grammar_card_${topic.id}")
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = topic.icon, fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = topic.getTitle(currentLanguage),
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Rule explanation
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = topic.getRule(currentLanguage),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(12.dp),
                    lineHeight = 22.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = when (currentLanguage) {
                    AppLanguage.BHOJPURI -> "उदाहरण:"
                    AppLanguage.NEPALI -> "उदाहरणहरू:"
                    AppLanguage.ENGLISH -> "Examples:"
                },
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Examples list
            topic.examples.forEach { example ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.2f))
                        .padding(10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = example.bhojpuri,
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = example.phonetic,
                                style = MaterialTheme.typography.labelSmall.copy(fontStyle = FontStyle.Italic),
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }

                        AudioButton(
                            textToSpeak = example.bhojpuri,
                            onSpeak = onSpeak,
                            isCurrentlySpeaking = isSpeaking && speakingText == example.bhojpuri,
                            size = 36.dp,
                            iconSize = 18.dp
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> example.bhojpuri
                            AppLanguage.NEPALI -> "नेपाली: ${example.nepali}"
                            AppLanguage.ENGLISH -> "English: ${example.english}"
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
