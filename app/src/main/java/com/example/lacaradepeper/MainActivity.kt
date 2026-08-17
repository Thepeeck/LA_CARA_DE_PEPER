package com.example.lacaradepeper

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.lacaradepeper.data.articles
import com.example.lacaradepeper.ui.screens.FeedScreen
import com.example.lacaradepeper.ui.theme.LACARADEPEPERTheme

private const val TAG = "LAB6-25555"
// aca con esto solo es e agreggarlo a logCat y ya esta, ya que con eso aparece el Onstart,Onresume,OnPause,OnStop,OnDestroy,OnCreate
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContent {
            LACARADEPEPERTheme {
                Scaffold { innerPadding ->
                    FeedScreen(
                        articles = articles,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}