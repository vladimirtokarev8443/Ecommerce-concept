package com.example.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "home_store")
    val hotSales: List<HotSales>,
    @Json(name = "best_seller")
    val bestSeller: List<BestSeller>
)
