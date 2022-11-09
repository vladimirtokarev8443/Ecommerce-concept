package com.example.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Basket(
    val id: Long,
    @Json(name = "images")
    val imageUrl: String,
    val price: Int,
    val title: String
)

