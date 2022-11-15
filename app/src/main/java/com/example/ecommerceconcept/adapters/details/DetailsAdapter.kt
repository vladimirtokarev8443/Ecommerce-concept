package com.example.ecommerceconcept.adapters.details

import androidx.recyclerview.widget.DiffUtil
import com.example.ecommerceconcept.models.DetailsSealed
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class DetailsAdapter:
    AsyncListDifferDelegationAdapter<DetailsSealed>(DetailsSealedDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(DetailsShopAdapterDelegate())
    }

    class DetailsSealedDiffUtilCallback : DiffUtil.ItemCallback<DetailsSealed>() {
        override fun areItemsTheSame(oldItem: DetailsSealed, newItem: DetailsSealed): Boolean {
            return when {
                oldItem is DetailsSealed.Shop && newItem is DetailsSealed.Shop ->
                    oldItem.id == newItem.id
                else -> false
            }

        }

        override fun areContentsTheSame(oldItem: DetailsSealed, newItem: DetailsSealed): Boolean {
            return oldItem == newItem
        }

    }

}