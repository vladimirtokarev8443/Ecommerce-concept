package com.example.domain.usecase

import com.example.domain.models.Cart
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class GetCartUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend fun execute(): Cart = productsRepository.getCart()
}