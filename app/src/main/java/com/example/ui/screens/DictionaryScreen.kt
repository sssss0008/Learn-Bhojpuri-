package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.AppLanguage
import com.example.model.UiStrings
import com.example.model.VocabularyItem
import com.example.model.WordCategory
import com.example.ui.components.VocabularyCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryScreen(
    currentLanguage: AppLanguage,
    vocabularies: List<VocabularyItem>,
    searchQuery: String,
    selectedCategory: WordCategory,
    onlyFavorites: Boolean,
    bookmarkedIds: Set<String>,
    masteredIds: Set<String>,
    isSpeaking: Boolean,
    speakingText: String?,
    onSearchChange: (String) -> Unit,
    onCategorySelected: (WordCategory) -> Unit,
    onToggleFavorites: () -> Unit,
    onSpeak: (String, Boolean) -> Unit,
    onToggleBookmark: (String) -> Unit,
    onToggleMastered: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        // Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("dictionary_search_input"),
            placeholder = { Text(UiStrings.searchHint(currentLanguage), fontSize = 14.sp) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { onSearchChange("") }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Clear")
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Filters: Favorites toggle and Category chips
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Favorites chip
            item {
                FilterChip(
                    selected = onlyFavorites,
                    onClick = onToggleFavorites,
                    label = { Text("⭐ " + UiStrings.bookmarks(currentLanguage)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = if (onlyFavorites) Color.White else MaterialTheme.colorScheme.tertiary
                        )
                    },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.tertiary,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.testTag("filter_favorites_chip")
                )
            }

            items(WordCategory.entries) { category ->
                val isSelected = !onlyFavorites && category == selectedCategory
                FilterChip(
                    selected = isSelected,
                    onClick = { onCategorySelected(category) },
                    label = { Text("${category.icon} ${category.getLabel(currentLanguage)}") },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary,
                        selectedLabelColor = Color.White
                    ),
                    modifier = Modifier.testTag("dict_filter_${category.id}")
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Results counter
        Text(
            text = "${vocabularies.size} ${when (currentLanguage) {
                AppLanguage.BHOJPURI -> "शब्द मिलल"
                AppLanguage.NEPALI -> "शब्दहरू भेटिए"
                AppLanguage.ENGLISH -> "words found"
            }}",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.outline
        )

        Spacer(modifier = Modifier.height(8.dp))

        if (vocabularies.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "🔍", fontSize = 42.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = when (currentLanguage) {
                            AppLanguage.BHOJPURI -> "कवनो शब्द ना मिलल"
                            AppLanguage.NEPALI -> "कुनै शब्द भेटिएन"
                            AppLanguage.ENGLISH -> "No words found"
                        },
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(bottom = 24.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(vocabularies, key = { it.id }) { item ->
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
    }
}
