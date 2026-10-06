package com.example.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.AppLanguage
import com.example.model.UiStrings
import com.example.viewmodel.AppScreen

@Composable
fun AppDrawerContent(
    currentLanguage: AppLanguage,
    currentScreen: AppScreen,
    streakDays: Int,
    totalXp: Int,
    onNavigate: (AppScreen) -> Unit,
    onOpenPracticeSubTab: (Int) -> Unit,
    onLanguageSelected: (AppLanguage) -> Unit,
    onCloseDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
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

    fun openEmail(email: String) {
        try {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:$email")
                putExtra(Intent.EXTRA_SUBJECT, "Bhojpuri Bhasa Feedback")
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Email app not available: $email", Toast.LENGTH_SHORT).show()
        }
    }

    fun openWhatsApp(phone: String) {
        try {
            val cleanPhone = phone.replace("+", "").replace(" ", "").trim()
            val url = "https://wa.me/$cleanPhone?text=Namaste!%20I%20am%20using%20the%20Bhojpuri%20Bhasa%20app."
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "WhatsApp not available", Toast.LENGTH_SHORT).show()
        }
    }

    ModalDrawerSheet(
        modifier = modifier.widthIn(max = 320.dp),
        drawerContainerColor = MaterialTheme.colorScheme.surface
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Header
            item {
                Surface(
                    shape = RoundedCornerShape(18.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(46.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primary),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "🌾", fontSize = 24.sp)
                            }

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(
                                    text = UiStrings.appTitle(currentLanguage),
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                                Text(
                                    text = "Bhojpuri Language & Culture",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Stats pills
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.surface
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocalFireDepartment,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "$streakDays ${UiStrings.days(currentLanguage)}",
                                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                                    )
                                }
                            }

                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.surface
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Stars,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.tertiary,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "$totalXp XP",
                                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Language Switcher in Drawer
            item {
                Text(
                    text = UiStrings.selectLanguage(currentLanguage),
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(start = 8.dp, top = 8.dp, bottom = 4.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    AppLanguage.entries.forEach { lang ->
                        val isSelected = lang == currentLanguage
                        Surface(
                            shape = RoundedCornerShape(10.dp),
                            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(10.dp))
                                .clickable { onLanguageSelected(lang) }
                        ) {
                            Text(
                                text = "${lang.badge} ${lang.nativeName}",
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                ),
                                color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurfaceVariant,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                        }
                    }
                }
            }

            item {
                Divider(
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }

            // Primary Navigation Items
            item {
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = null) },
                    label = { Text(UiStrings.homeTab(currentLanguage), fontWeight = FontWeight.SemiBold) },
                    selected = currentScreen == AppScreen.HOME,
                    onClick = {
                        onNavigate(AppScreen.HOME)
                        onCloseDrawer()
                    },
                    modifier = Modifier.testTag("drawer_item_home")
                )
            }

            item {
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.MenuBook, contentDescription = null) },
                    label = { Text(UiStrings.learnTab(currentLanguage), fontWeight = FontWeight.SemiBold) },
                    selected = currentScreen == AppScreen.LESSONS,
                    onClick = {
                        onNavigate(AppScreen.LESSONS)
                        onCloseDrawer()
                    },
                    modifier = Modifier.testTag("drawer_item_learn")
                )
            }

            item {
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Quiz, contentDescription = null) },
                    label = { Text(UiStrings.practiceTab(currentLanguage), fontWeight = FontWeight.SemiBold) },
                    selected = currentScreen == AppScreen.PRACTICE,
                    onClick = {
                        onNavigate(AppScreen.PRACTICE)
                        onCloseDrawer()
                    },
                    modifier = Modifier.testTag("drawer_item_practice")
                )
            }

            item {
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Translate, contentDescription = null) },
                    label = { Text(UiStrings.dictionaryTab(currentLanguage), fontWeight = FontWeight.SemiBold) },
                    selected = currentScreen == AppScreen.DICTIONARY,
                    onClick = {
                        onNavigate(AppScreen.DICTIONARY)
                        onCloseDrawer()
                    },
                    modifier = Modifier.testTag("drawer_item_dictionary")
                )
            }

            item {
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Festival, contentDescription = null) },
                    label = { Text(UiStrings.cultureHistory(currentLanguage), fontWeight = FontWeight.SemiBold) },
                    selected = currentScreen == AppScreen.CULTURE,
                    onClick = {
                        onNavigate(AppScreen.CULTURE)
                        onCloseDrawer()
                    },
                    modifier = Modifier.testTag("drawer_item_culture")
                )
            }

            item {
                NavigationDrawerItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = null) },
                    label = { Text(UiStrings.aboutTab(currentLanguage), fontWeight = FontWeight.SemiBold) },
                    selected = currentScreen == AppScreen.ABOUT,
                    onClick = {
                        onNavigate(AppScreen.ABOUT)
                        onCloseDrawer()
                    },
                    modifier = Modifier.testTag("drawer_item_about")
                )
            }

            item {
                Divider(
                    color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f),
                    modifier = Modifier.padding(vertical = 6.dp)
                )
            }

            // Developer & Feedback Section in Drawer
            item {
                Text(
                    text = UiStrings.contactDeveloper(currentLanguage),
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
                )

                Surface(
                    shape = RoundedCornerShape(14.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        // Email item
                        DrawerContactRow(
                            iconRes = R.drawable.ic_social_email,
                            title = "Email",
                            subtitle = feedbackEmail,
                            onClick = { openEmail(feedbackEmail) }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // WhatsApp item
                        DrawerContactRow(
                            iconRes = R.drawable.ic_social_whatsapp,
                            title = "WhatsApp",
                            subtitle = feedbackWhatsApp,
                            onClick = { openWhatsApp(feedbackWhatsApp) }
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        // LinkedIn item
                        DrawerContactRow(
                            iconRes = R.drawable.ic_social_linkedin,
                            title = "LinkedIn",
                            subtitle = "awiskaracharya",
                            onClick = { openUrl(feedbackLinkedIn) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DrawerContactRow(
    iconRes: Int,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp, horizontal = 4.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = title,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold))
            Text(text = subtitle, style = MaterialTheme.typography.bodySmall, maxLines = 1)
        }
        Icon(
            imageVector = Icons.Default.OpenInNew,
            contentDescription = "Open",
            tint = MaterialTheme.colorScheme.outline,
            modifier = Modifier.size(14.dp)
        )
    }
}
