package com.example.domain.repository

import com.example.domain.models.Cart
import com.example.domain.models.DetailsProduct
import com.example.domain.models.Product

interface ProductsRepository {

    suspend fun getProducts(): Product

    suspend fun getDetails(): DetailsProduct

    suspend fun getCart(): Cart

}