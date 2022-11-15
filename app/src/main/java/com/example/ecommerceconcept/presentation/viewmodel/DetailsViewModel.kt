package com.example.ecommerceconcept.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.DetailsProduct
import com.example.domain.usecase.GetDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getDetailsUseCase: GetDetailsUseCase
): ViewModel() {

    private val detailsMutLiveData = MutableLiveData<DetailsProduct>()
    val detailsLiveData: LiveData<DetailsProduct> get() = detailsMutLiveData

    init {
        getDetails()
    }

    private fun getDetails(){
        viewModelScope.launch {
            val details = getDetailsUseCase.execute()
            detailsMutLiveData.postValue(details)
        }
    }
}