package com.example.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class HotSales(
    val id: Int,
    @Json(name = "picture")
    val imageUrl: String,
    @Json(name = "title")
    val brand: String,
    @Json(name = "subtitle")
    val discription: String,
    @Json(name = "is_new")
    val isNew: Boolean = false,
    @Json(name = "is_buy")
    val isBuy: Boolean
)
