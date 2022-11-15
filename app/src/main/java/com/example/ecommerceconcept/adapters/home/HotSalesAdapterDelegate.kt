package com.example.ecommerceconcept.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.HotSales
import com.example.ecommerceconcept.databinding.ItemHotSalesBinding
import com.example.ecommerceconcept.utils.setImageGlide
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HotSalesAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
) : AbsListItemAdapterDelegate<HotSales, HotSales, HotSalesAdapterDelegate.PhonesHolder>(){


    override fun isForViewType(
        item: HotSales,
        items: MutableList<HotSales>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): PhonesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHotSalesBinding.inflate(inflater, parent, false)
        return PhonesHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(
        item: HotSales,
        holder: PhonesHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class PhonesHolder(
        val binding: ItemHotSalesBinding,
        private val onItemClicked: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: HotSales)= with(binding) {
            badgeImageView.isVisible = item.isNew
            badgeTextView.isVisible = item.isNew
            productImageView.setImageGlide(url = item.imageUrl)
            brandTextView.text = item.brand
            descriptionTextView.text = item.discription
        }
    }
}