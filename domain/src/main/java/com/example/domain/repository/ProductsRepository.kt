package com.example.domain.repository

import com.example.domain.models.Entity
import com.example.domain.models.Phones

interface ProductsRepository {

    suspend fun getProducts(): List<Entity>

    suspend fun getPhones(): Phones

}