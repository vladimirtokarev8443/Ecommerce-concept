package com.example.ecommerceconcept.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.HotSales
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class HotSalesAdapter(
    private val onItemClicked: (position: Int) -> Unit
): AsyncListDifferDelegationAdapter<HotSales>(HotSalesDiffUtilCallback()) {

    init{
        delegatesManager.addDelegate(HotSalesPhoneAdapterDelegate(onItemClicked))

    }



    class HotSalesDiffUtilCallback: DiffUtil.ItemCallback<HotSales>(){
        override fun areItemsTheSame(oldItem: HotSales, newItem: HotSales): Boolean {
            return when {
                oldItem is HotSales && newItem is HotSales ->
                    oldItem.id == newItem.id
                else -> false
            }
        }
        override fun areContentsTheSame(oldItem: HotSales, newItem: HotSales): Boolean {
            return oldItem == newItem
        }

    }

}