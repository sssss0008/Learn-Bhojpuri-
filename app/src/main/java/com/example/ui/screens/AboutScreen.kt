package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.BhojpuriDataSource
import com.example.model.AppLanguage
import com.example.model.CultureHistoryArticle
import com.example.model.UiStrings

@Composable
fun AboutScreen(
    currentLanguage: AppLanguage,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var showFeedbackDialog by remember { mutableStateOf(false) }
    var feedbackText by remember { mutableStateOf("") }
    var expandedArticleId by remember { mutableStateOf<String?>("art_chhath") }

    val feedbackEmail = "awiskaracharya@gmail.com"
    val feedbackWhatsApp = "+9779827106244"
    val feedbackLinkedIn = "https://www.linkedin.com/in/awiskaracharya/"

    fun openUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Could not open link", Toast.LENGTH_SHORT).show()
        }
    }

    fun openEmail(email: String, body: String = "") {
        try {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$email")
                putExtra(Intent.EXTRA_SUBJECT, "Bhojpuri Bhasa App Feedback")
                if (body.isNotEmpty()) putExtra(Intent.EXTRA_TEXT, body)
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Email app not found: $email", Toast.LENGTH_SHORT).show()
        }
    }

    fun openWhatsApp(phone: String, message: String = "") {
        try {
            val cleanPhone = phone.replace("+", "").replace(" ", "").trim()
            val encodedMsg = Uri.encode(if (message.isNotEmpty()) message else "Namaste! I am using the Bhojpuri Bhasa app.")
            val url = "https://wa.me/$cleanPhone?text=$encodedMsg"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "WhatsApp not available", Toast.LENGTH_SHORT).show()
        }
    }

    fun copyToClipboard(label: String, text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText(label, text))
        Toast.makeText(context, "$label copied to clipboard!", Toast.LENGTH_SHORT).show()
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(top = 12.dp, bottom = 28.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // App Identity Header
        item {
            Card(
                shape = RoundedCornerShape(22.dp),
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
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🌾", fontSize = 38.sp)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "भोजपुरी सीखल जाव (Bhojpuri Bhasa)",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "Bhojpuri • नेपाली • English Learning Platform",
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
                        color = MaterialTheme.colorScheme.secondary,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        color = MaterialTheme.colorScheme.surfaceVariant
                    ) {
                        Text(
                            text = "Version 1.0 • Nepal Terai & Purvanchal Edition",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "नेपाल के मधेश-तराई (पर्सा, बारा, रौतहट, सर्लाही) अउर भारत के पूर्वांचल के ऐतिहासिक भाषा के आधुनिक रूप में सीखे खातिर समर्पित एप।"
                            AppLanguage.NEPALI -> "नेपालको तराई-मधेश (पर्सा, बारा, रौतहट, सर्लाही) तथा भारतको पूर्वाञ्चलको ऐतिहासिक भाषा, लिपि र संस्कृतिलाई आधुनिक रूपमा सिक्ने डिजिटल माध्यम।"
                            AppLanguage.ENGLISH -> "A comprehensive cultural and linguistic platform dedicated to learning Bhojpuri with complete Nepali and English bridges, authentic phonetics, and historical roots."
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Center,
                        lineHeight = 21.sp
                    )
                }
            }
        }

        // Contact & Feedback Section (Prominent)
        item {
            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.35f)),
                border = CardDefaults.outlinedCardBorder(),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("contact_developer_card")
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.ContactSupport,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = UiStrings.contactDeveloper(currentLanguage),
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "सुझाव, प्रतिक्रिया भा कवनो सहायता खातिर सीधा संपर्क करीं:"
                            AppLanguage.NEPALI -> "सुझाव, प्रतिक्रिया वा कुनै सहयोगका लागि सिधै सम्पर्क गर्नुहोस्:"
                            AppLanguage.ENGLISH -> "For feedback, questions, or collaborations, feel free to reach out directly:"
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // 1. Email Button & Card
                    ContactChannelRow(
                        iconRes = R.drawable.ic_social_email,
                        channelName = "Email",
                        value = feedbackEmail,
                        actionLabel = "Send Mail",
                        onAction = { openEmail(feedbackEmail) },
                        onCopy = { copyToClipboard("Email", feedbackEmail) }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // 2. WhatsApp Button & Card
                    ContactChannelRow(
                        iconRes = R.drawable.ic_social_whatsapp,
                        channelName = "WhatsApp",
                        value = feedbackWhatsApp,
                        actionLabel = "Chat on WhatsApp",
                        onAction = { openWhatsApp(feedbackWhatsApp) },
                        onCopy = { copyToClipboard("WhatsApp Number", feedbackWhatsApp) }
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    // 3. LinkedIn Profile Button & Card
                    ContactChannelRow(
                        iconRes = R.drawable.ic_social_linkedin,
                        channelName = "LinkedIn",
                        value = "linkedin.com/in/awiskaracharya",
                        actionLabel = "Connect",
                        onAction = { openUrl(feedbackLinkedIn) },
                        onCopy = { copyToClipboard("LinkedIn URL", feedbackLinkedIn) }
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    // Open Feedback Dialog Button
                    Button(
                        onClick = { showFeedbackDialog = true },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("open_feedback_dialog_button")
                    ) {
                        Icon(imageVector = Icons.Default.RateReview, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = when (currentLanguage) {
                                AppLanguage.BHOJPURI -> "प्रतिक्रिया / सुझाव भेजीं"
                                AppLanguage.NEPALI -> "प्रतिक्रिया वा सुझाव पठाउनुहोस्"
                                AppLanguage.ENGLISH -> "Send In-App Feedback"
                            },
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        // Section Title: Culture, Traditions & History
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(text = "🪔", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = UiStrings.cultureHistory(currentLanguage),
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "परंपरा, इतिहास, कैथी लिपि अउर जीवन शैली"
                            AppLanguage.NEPALI -> "परम्परा, इतिहास, कैथी लिपि र जीवनशैली"
                            AppLanguage.ENGLISH -> "Living Traditions, History, Kaithi Script & Heritage"
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // List of Illustrated Culture & History Articles
        items(BhojpuriDataSource.cultureHistoryArticles, key = { it.id }) { article ->
            val isExpanded = expandedArticleId == article.id

            Card(
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                border = CardDefaults.outlinedCardBorder(),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .clickable {
                        expandedArticleId = if (isExpanded) null else article.id
                    }
                    .testTag("culture_article_${article.id}")
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    // Vector Art Banner if available
                    val drawableId = when (article.drawableResName) {
                        "ic_culture_chhath" -> R.drawable.ic_culture_chhath
                        "ic_culture_history" -> R.drawable.ic_culture_history
                        "ic_culture_theatre" -> R.drawable.ic_culture_theatre
                        else -> null
                    }

                    if (drawableId != null) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                        ) {
                            Image(
                                painter = painterResource(id = drawableId),
                                contentDescription = article.getTitle(currentLanguage),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                            // Subtle gradient overlay for contrast
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Black.copy(alpha = 0.1f))
                            )
                        }
                    }

                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = article.iconEmoji, fontSize = 24.sp)
                            Spacer(modifier = Modifier.width(10.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = article.getTitle(currentLanguage),
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = article.getSubtitle(currentLanguage),
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                            IconButton(onClick = {
                                expandedArticleId = if (isExpanded) null else article.id
                            }) {
                                Icon(
                                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                                    contentDescription = if (isExpanded) "Collapse" else "Expand"
                                )
                            }
                        }

                        AnimatedVisibility(visible = isExpanded) {
                            Column(modifier = Modifier.padding(top = 12.dp)) {
                                Divider(
                                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                                    thickness = 0.8.dp
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = article.getContent(currentLanguage),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface,
                                    lineHeight = 22.sp
                                )

                                // Additional language summary if user chose Bhojpuri or Nepali
                                if (currentLanguage != AppLanguage.ENGLISH) {
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Surface(
                                        shape = RoundedCornerShape(10.dp),
                                        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(10.dp)) {
                                            Text(
                                                text = "English Summary:",
                                                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                                                color = MaterialTheme.colorScheme.outline
                                            )
                                            Spacer(modifier = Modifier.height(2.dp))
                                            Text(
                                                text = article.contentEnglish,
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Interactive Feedback Dialog
    if (showFeedbackDialog) {
        AlertDialog(
            onDismissRequest = { showFeedbackDialog = false },
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Default.Feedback, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "अपन विचार लिखीं"
                            AppLanguage.NEPALI -> "आफ्नो प्रतिक्रिया लेख्नुहोस्"
                            AppLanguage.ENGLISH -> "Share Your Feedback"
                        },
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }
            },
            text = {
                Column {
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "राउर सुझाव से एह एप के अउर बेहतर बनावल जाई:"
                            AppLanguage.NEPALI -> "तपाईँको सुझावबाट यस एपलाई अझै परिष्कृत गरिनेछ:"
                            AppLanguage.ENGLISH -> "Your feedback helps improve lessons, translations, and cultural content:"
                        },
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = feedbackText,
                        onValueChange = { feedbackText = it },
                        placeholder = {
                            Text(
                                when (currentLanguage) {
                                    AppLanguage.BHOJPURI -> "कवनो नया शब्द, सुधार या विचार..."
                                    AppLanguage.NEPALI -> "कुनै नयाँ शब्द, सुधार वा विचार..."
                                    AppLanguage.ENGLISH -> "New words, corrections, or feature ideas..."
                                }
                            )
                        },
                        minLines = 3,
                        maxLines = 5,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    // Send via WhatsApp
                    OutlinedButton(
                        onClick = {
                            openWhatsApp(feedbackWhatsApp, feedbackText)
                            showFeedbackDialog = false
                            feedbackText = ""
                        },
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("WhatsApp")
                    }

                    // Send via Email
                    Button(
                        onClick = {
                            openEmail(feedbackEmail, feedbackText)
                            showFeedbackDialog = false
                            feedbackText = ""
                        },
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("Email")
                    }
                }
            },
            dismissButton = {
                TextButton(onClick = { showFeedbackDialog = false }) {
                    Text(
                        when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "रद्द करीं"
                            AppLanguage.NEPALI -> "रद्द गर्नुहोस्"
                            AppLanguage.ENGLISH -> "Cancel"
                        }
                    )
                }
            }
        )
    }
}

@Composable
private fun ContactChannelRow(
    iconRes: Int,
    channelName: String,
    value: String,
    actionLabel: String,
    onAction: () -> Unit,
    onCopy: () -> Unit
) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.surface,
        border = CardDefaults.outlinedCardBorder(),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = channelName,
                modifier = Modifier.size(28.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = channelName,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1
                )
            }

            IconButton(
                onClick = onCopy,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ContentCopy,
                    contentDescription = "Copy $channelName",
                    tint = MaterialTheme.colorScheme.outline,
                    modifier = Modifier.size(18.dp)
                )
            }

            FilledTonalButton(
                onClick = onAction,
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                modifier = Modifier.height(36.dp)
            ) {
                Text(text = actionLabel, style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold))
            }
        }
    }
}
