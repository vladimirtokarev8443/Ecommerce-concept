package com.example.data.repository

import com.example.data.RunMockyApi
import com.example.data.mapper.toEntityBestSeller
import com.example.data.mapper.toEntityHotSales
import com.example.domain.models.Entity
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: RunMockyApi
) : ProductsRepository {
    override suspend fun getProducts(): List<Entity> {
        val products = api.getProducts()
        return products.toEntityHotSales() + products.toEntityBestSeller()
    }
}