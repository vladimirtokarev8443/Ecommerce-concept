package com.example.domain.repository

import com.example.domain.models.Entity

interface ProductsRepository {

    suspend fun getProducts(): List<Entity>

}