package com.example.ecommerceconcept.models

import com.example.domain.models.BestSeller
import com.example.domain.models.Category
import com.example.domain.models.HotSales

data class HomeStoreState(
    val categories: List<Category>,
    val hotSales: List<HotSales>,
    val bestSeller: List<BestSeller>
)
