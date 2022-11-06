package com.example.domain.models

data class Category(
    val id: Int,
    val badgeImage: Int,
    val title: String,
    val isClick: Boolean = false
)
