package com.example.ecommerceconcept.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Category
import com.example.domain.models.Entity
import com.example.domain.usecase.GetProductUseCase
import com.example.domain.usecase.SelectedCategoryUseCase
import com.example.ecommerceconcept.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeStoreViewModel @Inject constructor(
    private val selectedCategoryUseCase: SelectedCategoryUseCase,
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {

    private val categoryMutLiveData = MutableLiveData<List<Category>>(createCategoryList())
    val categoryLiveData: LiveData<List<Category>> get() = categoryMutLiveData

    private val hotSalesMutLiveData = MutableLiveData<List<Entity>>()
    val hotSalesLiveData: LiveData<List<Entity>> get() = hotSalesMutLiveData

    private val bestSellerMutLiveData = MutableLiveData<List<Entity>>()
    val bestSellerLiveData: LiveData<List<Entity>> get() = bestSellerMutLiveData

    init {
        getHotSales()
    }


    fun getHotSales(){
        viewModelScope.launch {
            val products = getProductUseCase.execute()
            val hotSales = products.filter { it is Entity.HotSales }
            val bestSeller = products.filter { it is Entity.BestSeller }
            hotSalesMutLiveData.postValue(hotSales)
            bestSellerMutLiveData.postValue(bestSeller)
        }
    }



    fun onSelectedCategory(categoryId: Int) {
        categoryMutLiveData.postValue(
            selectedCategoryUseCase.execute(
                categoryList = categoryMutLiveData.value ?: emptyList(),
                selectId = categoryId
            )
        )

    }

    fun createCategoryList(): List<Category> {
        return listOf(
            Category(0, R.drawable.ic_phone, "Phones", true),
            Category(1, R.drawable.ic_computer, "Computer"),
            Category(2, R.drawable.ic_health, "Health"),
            Category(3, R.drawable.ic_books, "Books"),
            Category(4, R.drawable.ic_filters, "Example"),
            Category(5, R.drawable.ic_filters, "Example2")
        )
    }
}