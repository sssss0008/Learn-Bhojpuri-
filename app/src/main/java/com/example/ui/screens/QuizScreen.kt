package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.QuizItem
import com.example.model.QuizType
import com.example.model.UiStrings
import com.example.ui.components.AudioButton
import com.example.ui.theme.CorrectGreen
import com.example.ui.theme.CorrectGreenContainer
import com.example.ui.theme.WrongRed
import com.example.ui.theme.WrongRedContainer

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun QuizScreen(
    currentLanguage: AppLanguage,
    quizzes: List<QuizItem>,
    currentIndex: Int,
    selectedOption: String?,
    sentenceWords: List<String>,
    isChecked: Boolean,
    isCorrect: Boolean,
    score: Int,
    isFinished: Boolean,
    isSpeaking: Boolean,
    speakingText: String?,
    onSelectOption: (String) -> Unit,
    onAddSentenceWord: (String) -> Unit,
    onRemoveSentenceWord: (Int) -> Unit,
    onCheckAnswer: () -> Unit,
    onNextQuestion: () -> Unit,
    onRestartQuiz: () -> Unit,
    onSpeak: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    if (isFinished) {
        // Quiz Complete / Results Screen
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🏆", fontSize = 48.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = UiStrings.congratulations(currentLanguage),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${when (currentLanguage) {
                    AppLanguage.BHOJPURI -> "रउआ कुल अंक बाटे"
                    AppLanguage.NEPALI -> "तपाईँको कुल प्राप्ताङ्क"
                    AppLanguage.ENGLISH -> "Your total score"
                }}: $score / ${quizzes.size}",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                shape = RoundedCornerShape(14.dp),
                color = MaterialTheme.colorScheme.tertiaryContainer,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Stars,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "+${score * 25} XP ${UiStrings.xpPoints(currentLanguage)}",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onRestartQuiz,
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .height(50.dp)
                    .testTag("restart_quiz_button")
            ) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = when (currentLanguage) {
                        AppLanguage.BHOJPURI -> "फेरु से खेलीं"
                        AppLanguage.NEPALI -> "फेरि खेल्नुहोस्"
                        AppLanguage.ENGLISH -> "Play Again"
                    },
                    fontWeight = FontWeight.Bold
                )
            }
        }
        return
    }

    val currentQuiz = quizzes.getOrNull(currentIndex) ?: return

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentPadding = PaddingValues(bottom = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Progress header
        item {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "सवाल"
                            AppLanguage.NEPALI -> "प्रश्न"
                            AppLanguage.ENGLISH -> "Question"
                        }} ${currentIndex + 1} / ${quizzes.size}",
                        style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.primary
                    )

                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f)
                    ) {
                        Text(
                            text = when (currentQuiz.type) {
                                QuizType.MULTIPLE_CHOICE -> "Choice"
                                QuizType.SENTENCE_BUILDER -> "Sentence"
                                QuizType.LISTENING -> "Audio"
                            },
                            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                LinearProgressIndicator(
                    progress = { (currentIndex + 1).toFloat() / quizzes.size },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp)),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
            }
        }

        // Question Prompt Card
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                border = CardDefaults.outlinedCardBorder(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = currentQuiz.getPrompt(currentLanguage),
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        ),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    if (currentQuiz.targetAudioText.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            AudioButton(
                                textToSpeak = currentQuiz.targetAudioText,
                                onSpeak = onSpeak,
                                isCurrentlySpeaking = isSpeaking && speakingText == currentQuiz.targetAudioText,
                                size = 52.dp,
                                iconSize = 26.dp
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = UiStrings.listenAudio(currentLanguage),
                                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }

        // Quiz Interactive Controls based on type
        when (currentQuiz.type) {
            QuizType.MULTIPLE_CHOICE, QuizType.LISTENING -> {
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        currentQuiz.options.forEach { option ->
                            val isSelected = selectedOption == option
                            val isCorrectAnswer = isChecked && option == currentQuiz.correctAnswer
                            val isWrongSelected = isChecked && isSelected && !isCorrect

                            val borderColor = when {
                                isCorrectAnswer -> CorrectGreen
                                isWrongSelected -> WrongRed
                                isSelected -> MaterialTheme.colorScheme.primary
                                else -> MaterialTheme.colorScheme.outlineVariant
                            }

                            val containerColor = when {
                                isCorrectAnswer -> CorrectGreenContainer
                                isWrongSelected -> WrongRedContainer
                                isSelected -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                                else -> MaterialTheme.colorScheme.surface
                            }

                            Card(
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = containerColor),
                                border = BorderStroke(if (isSelected || isChecked) 2.dp else 1.dp, borderColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(14.dp))
                                    .clickable(enabled = !isChecked) { onSelectOption(option) }
                                    .testTag("quiz_option_${option.take(8)}")
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = option,
                                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                                        color = MaterialTheme.colorScheme.onSurface,
                                        modifier = Modifier.weight(1f)
                                    )

                                    if (isChecked) {
                                        if (isCorrectAnswer) {
                                            Icon(
                                                imageVector = Icons.Default.CheckCircle,
                                                contentDescription = "Correct",
                                                tint = CorrectGreen
                                            )
                                        } else if (isWrongSelected) {
                                            Icon(
                                                imageVector = Icons.Default.Cancel,
                                                contentDescription = "Wrong",
                                                tint = WrongRed
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            QuizType.SENTENCE_BUILDER -> {
                // Sentence Construction Area
                item {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                        ),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 90.dp)
                    ) {
                        FlowRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            if (sentenceWords.isEmpty()) {
                                Text(
                                    text = when (currentLanguage) {
                                        AppLanguage.BHOJPURI -> "नीचे से शब्द चुन के वाक्य सजावीं"
                                        AppLanguage.NEPALI -> "तलबाट शब्द छानेर वाक्य बनाउनुहोस्"
                                        AppLanguage.ENGLISH -> "Tap words below to build the sentence"
                                    },
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.outline,
                                    modifier = Modifier.padding(8.dp)
                                )
                            } else {
                                sentenceWords.forEachIndexed { index, word ->
                                    InputChip(
                                        selected = true,
                                        onClick = { if (!isChecked) onRemoveSentenceWord(index) },
                                        label = { Text(word, fontWeight = FontWeight.Bold) },
                                        trailingIcon = {
                                            if (!isChecked) {
                                                Icon(
                                                    imageVector = Icons.Default.Close,
                                                    contentDescription = "Remove",
                                                    modifier = Modifier.size(16.dp)
                                                )
                                            }
                                        },
                                        colors = InputChipDefaults.inputChipColors(
                                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                                        )
                                    )
                                }
                            }
                        }
                    }
                }

                // Scrambled Available Words to tap
                item {
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "उपलब्ध शब्द:"
                            AppLanguage.NEPALI -> "उपलब्ध शब्दहरू:"
                            AppLanguage.ENGLISH -> "Available Words:"
                        },
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    FlowRow(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        currentQuiz.scrambledWords.forEach { word ->
                            // Count times used
                            val countUsed = sentenceWords.count { it == word }
                            val totalAvailable = currentQuiz.scrambledWords.count { it == word }
                            val isAvailable = countUsed < totalAvailable && !isChecked

                            FilledTonalButton(
                                onClick = { onAddSentenceWord(word) },
                                enabled = isAvailable,
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.testTag("word_chip_$word")
                            ) {
                                Text(text = word, style = MaterialTheme.typography.bodyLarge)
                            }
                        }
                    }
                }
            }
        }

        // Feedback Card after checking
        if (isChecked) {
            item {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isCorrect) CorrectGreenContainer else WrongRedContainer
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (isCorrect) Icons.Default.CheckCircle else Icons.Default.Cancel,
                                contentDescription = null,
                                tint = if (isCorrect) CorrectGreen else WrongRed
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = if (isCorrect) UiStrings.correct(currentLanguage)
                                else UiStrings.wrong(currentLanguage),
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = if (isCorrect) CorrectGreen else WrongRed
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = currentQuiz.getExplanation(currentLanguage),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        // Action Buttons: Check or Next
        item {
            Spacer(modifier = Modifier.height(10.dp))
            if (!isChecked) {
                val canCheck = when (currentQuiz.type) {
                    QuizType.MULTIPLE_CHOICE, QuizType.LISTENING -> selectedOption != null
                    QuizType.SENTENCE_BUILDER -> sentenceWords.isNotEmpty()
                }

                Button(
                    onClick = onCheckAnswer,
                    enabled = canCheck,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("check_answer_button")
                ) {
                    Text(
                        text = UiStrings.check(currentLanguage),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }
            } else {
                Button(
                    onClick = onNextQuestion,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("next_question_button")
                ) {
                    Text(
                        text = if (currentIndex + 1 < quizzes.size) UiStrings.next(currentLanguage)
                        else UiStrings.finish(currentLanguage),
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}
