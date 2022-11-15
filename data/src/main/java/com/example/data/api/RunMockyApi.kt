package com.example.data.api

import com.example.domain.models.Cart
import com.example.domain.models.DetailsProduct
import com.example.domain.models.Product
import retrofit2.http.GET

interface RunMockyApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getProduct(): Product

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDetails(): DetailsProduct

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCart(): Cart


}