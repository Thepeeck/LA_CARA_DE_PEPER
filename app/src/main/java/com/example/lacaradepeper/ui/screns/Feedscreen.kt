package com.example.lacaradepeper.ui.screens

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun FeedScreen(
    articles: List<Article>,
    modifier: Modifier = Modifier
) {

    var selectedTab by rememberSaveable { mutableStateOf("para ti") }
    var searchQuery by rememberSaveable { mutableStateOf ("") }
    var showShortReadsOnly by rememberSaveable { mutableStateOf(false) }
    // cuando se puso el var applauseCount by remember { mutableStateOf(0) } ahi empso a funcionar casi todo ya que los aplausos funcionan y las rotacioes tambien, pero la busqueda esta un poco tosca
    // ademas aca el aplaudir se conta, pero cuando se rota, se pierde ese conteo y vuelve a 0
    var applauseCount by rememberSaveable() { mutableStateOf(0) }
    // cuando se cambio a var applauseCount = 0 se pudo ver que aunque el applauseCount esta funcionando, lo que hace es que el compose no esta observando la variable
    //lo que pasara es que el compose nunca se entra del cambio, asi que no se va aintroducir un numero

    // cuando se agrego el Rmemeber savable, se pudo ver que cuando se rota, no se pierde los aplausos, es decir se quedan iguales
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
    Column(modifier = modifier.fillMaxSize()) {
        TOPBAR()
        ELLETREROOO(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it}
        )
        Linea()
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            singleLine = true,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)

        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Switch(
                checked = showShortReadsOnly,
                onCheckedChange = { showShortReadsOnly = it }
            )
            Spacer(modifier = modifier.width(8.dp))
            Text("solo lecturas cortas")

            Spacer(modifier = Modifier.weight(1f))

            TextButton(onClick = { applauseCount++ }) {
                Text("Aplaudir · $applauseCount")
            }
        }
        if (visibleArticles.isEmpty()){
            Text(
                text = "No se encontraron artículos. Cambia la pestaña, la búsqueda o el filtro.",
                modifier = modifier.padding(16.dp)
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
fun FeedScreenPreview() {
    FeedScreen(articles = articles)
}

