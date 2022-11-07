package com.example.data.mapper

import com.example.data.models.Phones
import com.example.domain.models.BestSeller
import com.example.domain.models.Entity
import com.example.domain.models.HotSales

fun Phones.toEntityHotSales(): List<Entity> {
    return this.hotSalesList.map {
        Entity.HotSales(
        id = it.id,
            imageUrl = it.imageUrl,
            brand = it.brand,
            discription = it.discription,
            isNew = it.isNew
    ) }
}

fun Phones.toEntityBestSeller(): List<Entity> {
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

fun Phones.toHotSalesPhone(): List<HotSales> {
    return this.hotSalesList.map {
        HotSales.Phones(
            id = it.id,
            imageUrl = it.imageUrl,
            brand = it.brand,
            discription = it.discription,
            isNew = it.isNew
        ) }
}

fun Phones.toBestSellerPhone(): List<BestSeller> {
    return this.bestSellerList.map {
        BestSeller.Phones(
            id = it.id,
            imageUrl = it.imageUrl,
            title = it.title,
            price = it.price,
            priceDiscount = it.priceDiscount,
            favorites = it.favorites
        )}
}


