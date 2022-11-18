package com.example.ecommerceconcept.adapters.home

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.Category
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class CategoryAdapter(
    private val onItemClicked: (position: Int) -> Unit
) : AsyncListDifferDelegationAdapter<Category>(CategoryDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(CategoryAdapterDelegate(onItemClicked))
    }


    class CategoryDiffUtilCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

    }
}