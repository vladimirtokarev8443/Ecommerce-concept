package com.example.ecommerceconcept.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.Entity
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class EntityAdapter(
    private val onItemClicked: (position: Int) -> Unit
): AsyncListDifferDelegationAdapter<Entity>(EntityDiffUtilCallback()) {

    init{
        delegatesManager.addDelegate(HotSalesAdapterDelegate())
            .addDelegate(BestSellerAdapterDelegate())
    }



    class EntityDiffUtilCallback: DiffUtil.ItemCallback<Entity>(){
        override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return when {
                oldItem is Entity.HotSales && newItem is Entity.HotSales ->
                    oldItem.id == newItem.id
                oldItem is Entity.BestSeller && newItem is Entity.BestSeller ->
                    oldItem.id == newItem.id
                else -> false
            }
        }
        override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
            return oldItem == newItem
        }

    }

}
