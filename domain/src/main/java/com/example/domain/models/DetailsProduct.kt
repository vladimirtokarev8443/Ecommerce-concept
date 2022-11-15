package com.example.domain.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DetailsProduct(
    val id: String,
    @Json(name = "CPU")
    val cpu: String,
    val camera: String,
    val capacity: List<String>,
    val color: List<String>,
    val images: List<String>,
    val isFavorites: Boolean,
    val price: String,
    val rating: Float,
    val sd: String,
    val ssd: String,
    val title: String
)
