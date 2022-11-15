package com.example.ecommerceconcept.models

sealed class DetailsSealed{
    data class Shop(
        val id: Int,
        val cpu: String,
        val camera: String,
        val sd: String,
        val ssd: String,
        val capacity: List<String>,
        val color: List<String>
    ): DetailsSealed()
}
