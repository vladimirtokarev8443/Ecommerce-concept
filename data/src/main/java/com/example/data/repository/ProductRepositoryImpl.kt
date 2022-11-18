package com.example.data.repository

import com.example.data.api.RunMockyApi
import com.example.domain.models.Cart
import com.example.domain.models.DetailsProduct
import com.example.domain.models.Product
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: RunMockyApi
) : ProductsRepository {

    override suspend fun getProducts(): Product = api.getProduct()

    override suspend fun getDetailsProduct(): DetailsProduct = api.getDetailsProduct()

    override suspend fun getCart(): Cart = api.getCart()

}