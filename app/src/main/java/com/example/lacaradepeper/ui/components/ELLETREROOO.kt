package com.example.lacaradepeper.ui.components

import android.app.ActionBar
import android.icu.text.SymbolTable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement

@Composable
fun ELLETREROOO(
     selectedTab: String,
     onTabSelected: (String) ->Unit,
    modifier: Modifier = Modifier
) {
    val tabs = listOf("para vos", "siguiendo", "Nuevos Articulos")
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp,    vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        tabs.forEach { tab ->
            val isSelected = tab == selectedTab
            Text(
                text = tab,
                fontSize = 14.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) Color(0xFF242424) else Color.Gray,
                modifier = Modifier.clickable { onTabSelected(tab) }
            )
        }
    }

}