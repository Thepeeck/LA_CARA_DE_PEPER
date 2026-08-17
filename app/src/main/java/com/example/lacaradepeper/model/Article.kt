package com.example.lacaradepeper.model

import androidx.compose.ui.graphics.Color

data class Article(
    val name: String, val date: String ,val title: String, val description: String, val readtime: Int, val avatarColor: Color, val thumbnailColor: Color, val isAuthorFollowed :  Boolean, val isFeatured: Boolean
)