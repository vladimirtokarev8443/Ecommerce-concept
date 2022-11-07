package com.example.domain.usecase

import com.example.domain.models.Entity
import com.example.domain.models.Phones
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class GetPhonesUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend fun execute1(): List<Entity> = productsRepository.getProducts()

    suspend fun execute(): Phones = productsRepository.getPhones()
}