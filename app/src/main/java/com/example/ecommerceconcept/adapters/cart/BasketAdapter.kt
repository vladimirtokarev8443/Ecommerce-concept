package com.example.ecommerceconcept.adapters.cart

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.Basket
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class BasketAdapter :
    AsyncListDifferDelegationAdapter<Basket>(BasketDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(BasketAdapterDelegate())
    }

    class BasketDiffUtilCallback : DiffUtil.ItemCallback<Basket>() {
        override fun areItemsTheSame(oldItem: Basket, newItem: Basket): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Basket, newItem: Basket): Boolean {
            return oldItem == newItem
        }

    }
}