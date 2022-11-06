package com.example.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BestSeller(
    @Json(name = "id")
    val id: Int,
    @Json(name = "picture")
    val imageUrl: String,
    @Json(name = "title")
    val title: String,
    @Json(name = "discount_price")
    val price: Int,
    @Json(name = "price_without_discount")
    val priceDiscount: Int,
    @Json(name = "is_favorites")
    val favorites: Boolean
)
