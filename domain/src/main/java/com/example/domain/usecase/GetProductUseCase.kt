package com.example.domain.usecase

import com.example.domain.models.Entity
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend fun execute(): List<Entity> = productsRepository.getProducts()
}