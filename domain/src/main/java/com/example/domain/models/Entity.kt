package com.example.domain.models

sealed class Entity{

    data class HotSales(
        val id: Int,
        val imageUrl: String,
        val brand: String,
        val discription: String,
        val isNew: Boolean = false
    ): Entity()

    data class BestSeller(
        val id: Int,
        val productImage: String,
        val title: String,
        val price: Int,
        val priceDiscount: Int,
        val favorites: Boolean
    ): Entity()


}
