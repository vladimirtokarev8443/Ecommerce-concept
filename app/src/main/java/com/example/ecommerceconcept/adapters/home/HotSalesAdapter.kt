package com.example.ecommerceconcept.adapters.home

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.HotSales
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class HotSalesAdapter(
    private val onItemClicked: (position: Int) -> Unit
) : AsyncListDifferDelegationAdapter<HotSales>(HotSalesDiffUtilCallback()) {

    init {
        delegatesManager.addDelegate(HotSalesAdapterDelegate(onItemClicked))
    }


    class HotSalesDiffUtilCallback : DiffUtil.ItemCallback<HotSales>() {
        override fun areItemsTheSame(oldItem: HotSales, newItem: HotSales): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HotSales, newItem: HotSales): Boolean {
            return oldItem == newItem
        }

    }

}