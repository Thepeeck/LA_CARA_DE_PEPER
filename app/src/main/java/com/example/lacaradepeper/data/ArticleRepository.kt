package com.example.lacaradepeper.data

import androidx.compose.ui.graphics.Color
import com.example.lacaradepeper.model.Article
import kotlin.collections.List

val articles: List<Article> = listOf(
    Article(
        name = "Ignacio Guardado",
        title = "porque el nacho perfecto no existe en el mundo?",
        description = "investigando porque no hay un nacho superior que supere a todos los nachos.",
        readtime = 10,
        date = "Dec 12",
        avatarColor = Color(0xFFE8A33D),
        thumbnailColor = Color(0xFFF0D9A8),
        isAuthorFollowed = true,
        isFeatured = false
    ),


    Article(
        name = "Agustin Arrecci",
        title = "Como hacer el mejor pastel de chocolate",
        description = "Un pastel hecho de todos los chocolates del mundo, con un sabor exquisito ",
        readtime = 6,
        date = "jun 5",
        avatarColor = Color(0xFF7BA98C),
        thumbnailColor = Color(0xFFC9DDC7),
        isAuthorFollowed = false,
        isFeatured = true
    ),

    Article(
        name = "Alegandra Larios",
        title = "Como hacer un arroz bien, pero bien CHINO",
        description = "Aca se parendera a hacer un arroz chino digno de los dioses, usando ingrdientes basicos",
        readtime = 9,
        date = "Dec 12",
        avatarColor = Color(0xFFB16B5A),
        thumbnailColor = Color(0xFFE3C7A0),
        isAuthorFollowed = false,
        isFeatured = false
    )

)
