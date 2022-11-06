package com.example.data.mapper

import com.example.data.models.Products
import com.example.domain.models.Entity

fun Products.toEntityHotSales(): List<Entity> {
    return this.hotSalesList.map {
        Entity.HotSales(
        id = it.id,
            imageUrl = it.imageUrl,
            brand = it.brand,
            discription = it.discription,
            isNew = it.isNew
    ) }
}

fun Products.toEntityBestSeller(): List<Entity> {
    return this.bestSellerList.map {
        Entity.BestSeller(
            id = it.id,
            productImage = it.imageUrl,
            title = it.title,
            price = it.price,
            priceDiscount = it.priceDiscount,
            favorites = it.favorites
        )}
}
