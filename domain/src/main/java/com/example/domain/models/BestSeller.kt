package com.example.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BestSeller(
    val id: Int,
    @Json(name = "picture")
    val imageUrl: String,
    val title: String,
    @Json(name = "discount_price")
    val price: Int,
    @Json(name = "price_without_discount")
    val priceDiscount: Int,
    @Json(name = "is_favorites")
    val favorites: Boolean
)
