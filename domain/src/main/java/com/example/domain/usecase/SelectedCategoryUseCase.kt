package com.example.domain.usecase

import com.example.domain.models.Category

class SelectedCategoryUseCase {

    fun execute(categoryList: List<Category>, selectId: Int): List<Category>{
        return categoryList.map { category -> category.copy(isClick = category.id == selectId) }
    }

}