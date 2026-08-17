package com.example.lacaradepeper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.lacaradepeper.data.articles
import com.example.lacaradepeper.ui.screens.FeedScreen
import com.example.lacaradepeper.ui.theme.LACARADEPEPERTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LACARADEPEPERTheme{
                Scaffold { innerPadding ->
                    FeedScreen(
                        articles = articles,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}