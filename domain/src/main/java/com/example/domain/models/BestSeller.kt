package com.example.domain.models

sealed class BestSeller {
    data class Phones(
        val id: Int,
        val imageUrl: String,
        val title: String,
        val price: Int,
        val priceDiscount: Int,
        val favorites: Boolean
        ): BestSeller()
    data class Computer(val id: Int): BestSeller()
    data class Health(val id: Int): BestSeller()
    data class Books(val id: Int): BestSeller()
}