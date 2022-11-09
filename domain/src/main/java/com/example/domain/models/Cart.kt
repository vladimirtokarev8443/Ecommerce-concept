package com.example.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cart(
    val id: Long,
    @Json(name = "basket")
    val basketList: List<Basket>,
    val delivery: String,
    val total: Int
)
