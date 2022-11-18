package com.example.domain.models

data class Category(
    val id: Int,
    val iconRes: Int,
    val title: String,
    val isClick: Boolean = false
)
