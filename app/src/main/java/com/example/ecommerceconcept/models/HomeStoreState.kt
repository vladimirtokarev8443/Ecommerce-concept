package com.example.ecommerceconcept.models

import com.example.domain.models.BestSeller
import com.example.domain.models.Category
import com.example.domain.models.HotSales

data class HomeStoreState(
    var selectCategory: Int = 0,
    var categories: List<Category> = emptyList(),
    var hotSalesPhones: List<HotSales> = emptyList(),
    var bestSellerPhones: List<BestSeller> = emptyList(),
    var hotSalesComputer: List<HotSales> = emptyList(),
    var bestSellerComputer: List<BestSeller> = emptyList()
)
