package com.example.ecommerceconcept.di

import com.example.domain.repository.ProductsRepository
import com.example.domain.usecase.GetCartUseCase
import com.example.domain.usecase.GetDetailsProductUseCase
import com.example.domain.usecase.GetProductUseCase
import com.example.domain.usecase.SelectedCategoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModul {

    @Provides
    fun providesSelectedCategoryUseCase(): SelectedCategoryUseCase{
        return SelectedCategoryUseCase()
    }

    @Provides
    fun providesGetProductUseCase(productsRepository: ProductsRepository): GetProductUseCase {
        return GetProductUseCase(productsRepository)
    }

    @Provides
    fun providesGetCartUseCase(productsRepository: ProductsRepository): GetCartUseCase {
        return GetCartUseCase(productsRepository)
    }

    @Provides
    fun providesGetDetailUseCase(productsRepository: ProductsRepository): GetDetailsProductUseCase {
        return GetDetailsProductUseCase(productsRepository)
    }
}