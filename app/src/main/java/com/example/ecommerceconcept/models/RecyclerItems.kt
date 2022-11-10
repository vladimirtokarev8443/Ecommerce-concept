package com.example.ecommerceconcept.models

import com.example.domain.models.HotSales


sealed class RecyclerItems{

    data class Header(
        val id: Int = 0,
        val hotSales: HotSales
    ): RecyclerItems()

    data class Phone(
        val id: Int,
        val imageUrl: String,
        val title: String,
        val price: Int,
        val priceDiscount: Int,
        val favorites: Boolean
        ): RecyclerItems()
}
