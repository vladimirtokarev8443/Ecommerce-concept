package com.example.ecommerceconcept.adapters.home

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.BestSeller
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class BestSellerAdapter(
    private val onItemClicked: (position: Int) -> Unit
):
    AsyncListDifferDelegationAdapter<BestSeller>(RecyclerItemsDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(BestSellerAdapterDelegate(onItemClicked))
    }

    class RecyclerItemsDiffUtilCallback : DiffUtil.ItemCallback<BestSeller>() {
        override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
            return oldItem == newItem
        }

    }
}