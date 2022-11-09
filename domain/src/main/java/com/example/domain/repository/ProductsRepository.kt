package com.example.domain.repository

import com.example.domain.models.Cart
import com.example.domain.models.Product

interface ProductsRepository {

    suspend fun getProducts(): Product

    suspend fun getDetails()

    suspend fun getCart(): Cart

}