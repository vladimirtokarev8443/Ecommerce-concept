package com.example.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Phones(
    @Json(name = "home_store")
    val hotSalesList: List<HotSales> ,
    @Json(name = "best_seller")
    val bestSellerList: List<BestSeller>
)
