package com.example.ecommerceconcept.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.HotSales
import com.example.ecommerceconcept.databinding.ItemHotSalesPhoneBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HotSalesPhoneAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
) : AbsListItemAdapterDelegate<HotSales.Phones, HotSales, HotSalesPhoneAdapterDelegate.PhonesHolder>(){


    override fun isForViewType(
        item: HotSales,
        items: MutableList<HotSales>,
        position: Int
    ): Boolean {
        return item is HotSales.Phones
    }

    override fun onCreateViewHolder(parent: ViewGroup): PhonesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHotSalesPhoneBinding.inflate(inflater, parent, false)
        return PhonesHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(
        item: HotSales.Phones,
        holder: PhonesHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class PhonesHolder(
        val binding: ItemHotSalesPhoneBinding,
        private val onItemClicked: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: HotSales.Phones){

        }
    }
}