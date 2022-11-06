package com.example.ecommerceconcept.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.BestSeller
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class BestSellerAdapter (
    private val onItemClicked: (position: Int) -> Unit
): AsyncListDifferDelegationAdapter<BestSeller>(BestSellerDiffUtilCallback()) {

    init{
        delegatesManager.addDelegate(BestSellerPhoneAdapterDelegate(onItemClicked))

    }

    class BestSellerDiffUtilCallback: DiffUtil.ItemCallback<BestSeller>(){
        override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
            return when {
                oldItem is BestSeller.Phones && newItem is BestSeller.Phones ->
                    oldItem.id == newItem.id
                oldItem is BestSeller.Computer && newItem is BestSeller.Computer ->
                    oldItem.id == newItem.id
                oldItem is BestSeller.Health && newItem is BestSeller.Health ->
                    oldItem.id == newItem.id
                oldItem is BestSeller.Books && newItem is BestSeller.Books ->
                    oldItem.id == newItem.id
                else -> false
            }
        }
        override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
            return oldItem == newItem
        }

    }

}