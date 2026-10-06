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
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.BhojpuriDataSource
import com.example.model.AppLanguage
import com.example.model.ConversationDialogue
import com.example.model.DialogueLine
import com.example.ui.components.AudioButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConversationScreen(
    currentLanguage: AppLanguage,
    selectedDialogue: ConversationDialogue?,
    isSpeaking: Boolean,
    speakingText: String?,
    onSelectDialogue: (ConversationDialogue) -> Unit,
    onCloseDialogue: () -> Unit,
    onSpeak: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    if (selectedDialogue != null) {
        BackHandler {
            onCloseDialogue()
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Column {
                            Text(
                                text = selectedDialogue.getTitle(currentLanguage),
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = selectedDialogue.getScenario(currentLanguage),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = onCloseDialogue,
                            modifier = Modifier.testTag("back_from_dialogue")
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
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
                contentPadding = PaddingValues(top = 12.dp, bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(selectedDialogue.lines) { line ->
                    DialogueBubble(
                        line = line,
                        currentLanguage = currentLanguage,
                        isSpeaking = isSpeaking,
                        speakingText = speakingText,
                        onSpeak = onSpeak
                    )
                }
            }
        }
    } else {
        // Dialogue Scenarios List
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
                        AppLanguage.BHOJPURI -> "आम बोलचाल के संवाद"
                        AppLanguage.NEPALI -> "दैनिक कुराकानीका संवादहरू"
                        AppLanguage.ENGLISH -> "Everyday Conversations"
                    },
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "गाँव, दोकान अउर बजार में बोले के असली तरीका"
                        AppLanguage.NEPALI -> "गाउँ, पसल र बजारमा बोलिने व्यावहारिक संवाद"
                        AppLanguage.ENGLISH -> "Realistic scenarios to practice natural spoken dialogue"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            items(BhojpuriDataSource.dialogues, key = { it.id }) { dialogue ->
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    border = CardDefaults.outlinedCardBorder(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(18.dp))
                        .clickable { onSelectDialogue(dialogue) }
                        .testTag("dialogue_card_${dialogue.id}")
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(CircleShape)
                                .background(MaterialTheme.colorScheme.primaryContainer),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = dialogue.icon, fontSize = 24.sp)
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = dialogue.getTitle(currentLanguage),
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = dialogue.getScenario(currentLanguage),
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 2
                            )
                        }

                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Open",
                            tint = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DialogueBubble(
    line: DialogueLine,
    currentLanguage: AppLanguage,
    isSpeaking: Boolean,
    speakingText: String?,
    onSpeak: (String, Boolean) -> Unit
) {
    val isPrimary = line.isPrimarySpeaker

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isPrimary) Arrangement.Start else Arrangement.End
    ) {
        Card(
            shape = RoundedCornerShape(
                topStart = 16.dp,
                topEnd = 16.dp,
                bottomStart = if (isPrimary) 4.dp else 16.dp,
                bottomEnd = if (isPrimary) 16.dp else 4.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = if (isPrimary) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
                else MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.45f)
            ),
            modifier = Modifier.fillMaxWidth(0.92f)
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                // Speaker Badge & Audio
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = line.getSpeakerName(currentLanguage),
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = if (isPrimary) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    AudioButton(
                        textToSpeak = line.bhojpuri,
                        onSpeak = onSpeak,
                        isCurrentlySpeaking = isSpeaking && speakingText == line.bhojpuri,
                        size = 36.dp,
                        iconSize = 18.dp
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Bhojpuri line
                Text(
                    text = line.bhojpuri,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = line.phonetic,
                    style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
                    color = MaterialTheme.colorScheme.secondary
                )

                Spacer(modifier = Modifier.height(8.dp))

                Divider(
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    thickness = 0.8.dp
                )

                Spacer(modifier = Modifier.height(6.dp))

                // Translations in active and other languages
                Text(
                    text = line.getTranslation(currentLanguage),
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onSurface
                )

                if (currentLanguage != AppLanguage.NEPALI) {
                    Text(
                        text = "नेपाली: ${line.nepali}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                if (currentLanguage != AppLanguage.ENGLISH) {
                    Text(
                        text = "English: ${line.english}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
