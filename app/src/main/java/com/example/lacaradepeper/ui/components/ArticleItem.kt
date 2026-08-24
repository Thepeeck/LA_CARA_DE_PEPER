package com.example.lacaradepeper.ui.components

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lacaradepeper.model.Article

@Composable
fun Article(
    article: Article,
    modifier: Modifier

){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 14.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        Column(modifier = Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(article.avatarColor)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(article.title, fontSize = 12.sp, color = Color.Gray)

            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(article.title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                article.description,
                fontSize = 14.sp,
                color = Color.DarkGray,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row() {
                Text("${article.readtime}min read", fontSize = 12.sp,color = Color.Gray)
                Text(" · ${article.date}", fontSize = 12.sp, color = Color.Gray)
            }

        }
        Box( modifier = Modifier
            .size(80.dp)
            .background(article.thumbnailColor))
    }
}