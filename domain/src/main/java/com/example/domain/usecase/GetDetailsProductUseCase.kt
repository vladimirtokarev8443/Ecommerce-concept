package com.example.domain.usecase

import com.example.domain.models.DetailsProduct
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class GetDetailsProductUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend fun execute(): DetailsProduct = productsRepository.getDetailsProduct()
}