package com.example.ecommerceconcept.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Category
import com.example.domain.usecase.GetPhonesUseCase
import com.example.domain.usecase.SelectedCategoryUseCase
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.models.HomeStoreState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeStoreViewModel @Inject constructor(
    private val selectedCategoryUseCase: SelectedCategoryUseCase,
    private val getPhonesUseCase: GetPhonesUseCase
) : ViewModel() {

    private val uiStateMutLiveData = MutableLiveData<HomeStoreState>()
    val uiStateLiveData: LiveData<HomeStoreState> get() = uiStateMutLiveData

    init {
        createCategory()
        getPhones()
    }

    private fun createCategory(){
        uiStateMutLiveData.postValue(HomeStoreState(categories = createCategoryList()))
    }

    fun getPhones(){
        viewModelScope.launch {
            try {
                val product = getPhonesUseCase.execute()
                val ui = uiStateMutLiveData.value?.copy(
                    hotSalesPhones = product.hotSales,
                    bestSellerPhones = product.bestSeller
                )
                ui?.let{ uiStateMutLiveData.postValue(it) }
            } catch (e: Exception){}
        }
    }

    fun onSelectedCategory(categoryId: Int) {
        val ui = uiStateMutLiveData.value?.copy(
            categories =  selectedCategoryUseCase.execute(
                categoryList = uiStateMutLiveData.value?.categories ?: createCategoryList(),
                selectId = categoryId
            )
        )
        ui?.let { uiStateMutLiveData.postValue(it) }

    }


    fun createCategoryList(): List<Category> {
        return listOf(
            Category(0, R.drawable.ic_phone, "Phones", true),
            Category(1, R.drawable.ic_computer, "Computer"),
            Category(2, R.drawable.ic_health, "Health"),
            Category(3, R.drawable.ic_books, "Books"),
            Category(4, R.drawable.ic_books, "Example"),
            Category(5, R.drawable.ic_books, "Example2")
        )
    }
}