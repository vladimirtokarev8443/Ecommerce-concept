package com.example.data.repository

import com.example.data.RunMockyApi
import com.example.data.mapper.toBestSellerPhone
import com.example.data.mapper.toEntityBestSeller
import com.example.data.mapper.toEntityHotSales
import com.example.data.mapper.toHotSalesPhone
import com.example.domain.models.Entity
import com.example.domain.models.Phones
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: RunMockyApi
) : ProductsRepository {
    override suspend fun getProducts(): List<Entity> {
        val products = api.getPhones()
        return products.toEntityHotSales() + products.toEntityBestSeller()
    }

    override suspend fun getPhones(): Phones {
        val phonesData = api.getPhones()
        return Phones(
            hotSalesList = phonesData.toHotSalesPhone(),
            bestSellerList = phonesData.toBestSellerPhone()
        )
    }
}