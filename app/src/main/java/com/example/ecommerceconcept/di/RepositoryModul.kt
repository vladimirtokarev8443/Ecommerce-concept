package com.example.ecommerceconcept.di

import com.example.data.api.RunMockyApi
import com.example.data.repository.ProductRepositoryImpl
import com.example.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModul {

    @Provides
    fun providesProductRepository(api: RunMockyApi): ProductsRepository {
        return ProductRepositoryImpl(api)
    }
}