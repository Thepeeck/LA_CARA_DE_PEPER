package com.example.lacaradepeper.ui.screns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lacaradepeper.data.articles
import com.example.lacaradepeper.model.Article
import com.example.lacaradepeper.ui.components.ArticleItem
import com.example.lacaradepeper.ui.components.ELLETREROOO
import com.example.lacaradepeper.ui.components.Linea
import com.example.lacaradepeper.ui.components.TOPBAR

@Composable
fun FeedContent(
    visibleArticles: List<Article>,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    showShortReadsOnly: Boolean,
    onShortReadsOnlyChange: (Boolean) -> Unit,
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    applauseCount: Int,
    onApplaud: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxSize()) {
        TOPBAR()
        ELLETREROOO(
            selectedTab = selectedTab,
            onTabSelected = onTabSelected
        )
        Linea()
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchQueryChange,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = showShortReadsOnly,
                onCheckedChange = onShortReadsOnlyChange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("solo lecturas cortas")

            Spacer(modifier = Modifier.weight(1f))

            TextButton(onClick = onApplaud) {
                Text("Aplaudir · $applauseCount")
            }
        }
        if (visibleArticles.isEmpty()) {
            Text(
                text = "No se encontraron artículos. Cambia la pestaña, la búsqueda o el filtro.",
                modifier = Modifier.padding(16.dp)
            )
        } else {
            visibleArticles.forEach { article ->
                ArticleItem(article = article)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedContentPreview() {
    FeedContent(
        visibleArticles = articles,
        searchQuery = "",
        onSearchQueryChange = {},
        showShortReadsOnly = false,
        onShortReadsOnlyChange = {},
        selectedTab = "para ti",
        onTabSelected = {},
        applauseCount = 3,
        onApplaud = {}
    )
}

@Preview(showBackground = true)
@Composable
fun FeedContentEmptyPreview() {
    FeedContent(
        visibleArticles = emptyList(),
        searchQuery = "xyz",
        onSearchQueryChange = {},
        showShortReadsOnly = false,
        onShortReadsOnlyChange = {},
        selectedTab = "para ti",
        onTabSelected = {},
        applauseCount = 0,
        onApplaud = {}
    )
}