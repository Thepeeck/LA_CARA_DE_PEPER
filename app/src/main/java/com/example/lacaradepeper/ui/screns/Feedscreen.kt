package com.example.lacaradepeper.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lacaradepeper.data.articles
import com.example.lacaradepeper.model.Article
import com.example.lacaradepeper.ui.screns.FeedContent

@Composable
fun FeedScreen(
    articles: List<Article>,
    modifier: Modifier = Modifier
) {
    var selectedTab by rememberSaveable { mutableStateOf("para ti") }
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var showShortReadsOnly by rememberSaveable { mutableStateOf(false) }
    var applauseCount by rememberSaveable { mutableStateOf(0) }

    val visibleArticles: List<Article> = articles.filter { article ->
        val matchesTab = when (selectedTab) {
            "siguiendo" -> article.isAuthorFollowed
            "Destacados" -> article.isFeatured
            else -> true
        }
        val matchesReadLength = !showShortReadsOnly || article.readtime <= 5
        val matchesSearch = searchQuery.isBlank() ||
                article.title.contains(searchQuery, ignoreCase = true) ||
                article.name.contains(searchQuery, ignoreCase = true)

        matchesTab && matchesReadLength && matchesSearch
    }

    FeedContent(
        visibleArticles = visibleArticles,
        searchQuery = searchQuery,
        onSearchQueryChange = { searchQuery = it },
        showShortReadsOnly = showShortReadsOnly,
        onShortReadsOnlyChange = { showShortReadsOnly = it },
        selectedTab = selectedTab,
        onTabSelected = { selectedTab = it },
        applauseCount = applauseCount,
        onApplaud = { applauseCount++ },
        modifier = modifier
    )
}
@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    FeedScreen(articles = articles)
}

