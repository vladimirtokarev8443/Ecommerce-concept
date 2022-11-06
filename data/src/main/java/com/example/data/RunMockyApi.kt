package com.example.data

import com.example.data.models.Products
import retrofit2.http.GET

interface RunMockyApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getProducts(): Products

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun getModelDetails()

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    fun getCart()
}