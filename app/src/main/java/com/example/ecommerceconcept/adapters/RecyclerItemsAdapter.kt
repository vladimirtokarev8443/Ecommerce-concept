package com.example.ecommerceconcept.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.Basket
import com.example.ecommerceconcept.models.RecyclerItems
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class RecyclerItemsAdapter:
    AsyncListDifferDelegationAdapter<RecyclerItems>(RecyclerItemsDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(BasketAdapterDelegate())
    }

    class RecyclerItemsDiffUtilCallback : DiffUtil.ItemCallback<RecyclerItems>() {
        override fun areItemsTheSame(oldItem: RecyclerItems, newItem: RecyclerItems): Boolean {
            return when{
                oldItem is RecyclerItems.Header && newItem is RecyclerItems.Header ->
                    oldItem.id == newItem.id
                oldItem is RecyclerItems.Phone && newItem is RecyclerItems.Phone ->
                    oldItem.id == newItem.id
                else -> false
            }
        }

        override fun areContentsTheSame(oldItem: RecyclerItems, newItem: RecyclerItems): Boolean {
            return oldItem == newItem
        }

    }
}