package com.example.ecommerceconcept.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Cart
import com.example.domain.usecase.GetCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase
): ViewModel() {

    private val cartMutLiveData = MutableLiveData<Cart>()
    val cartLiveData: LiveData<Cart> get() = cartMutLiveData

    init {
        getCart()
    }

    private fun getCart(){
        viewModelScope.launch {
            cartMutLiveData.postValue(getCartUseCase.execute())
        }
    }

}