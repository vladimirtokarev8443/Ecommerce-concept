package com.example.domain.models

sealed class HotSales{
    data class Phones(
        val id: Int,
        val imageUrl: String,
        val brand: String,
        val discription: String,
        val isNew: Boolean = false
    ): HotSales()

}
