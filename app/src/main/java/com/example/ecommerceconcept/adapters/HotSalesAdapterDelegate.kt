package com.example.ecommerceconcept.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Entity
import com.example.ecommerceconcept.databinding.ItemHotSalesBinding
import com.example.ecommerceconcept.utils.setImageGlide
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HotSalesAdapterDelegate :
    AbsListItemAdapterDelegate<Entity.HotSales, Entity, HotSalesAdapterDelegate.HotSalesHolder>() {

    override fun isForViewType(item: Entity, items: MutableList<Entity>, position: Int): Boolean {
        return item is Entity.HotSales
    }

    override fun onCreateViewHolder(parent: ViewGroup): HotSalesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHotSalesBinding.inflate(inflater, parent, false)
        return HotSalesHolder(binding)
    }

    override fun onBindViewHolder(
        item: Entity.HotSales,
        holder: HotSalesHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class HotSalesHolder(
        val binding: ItemHotSalesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Entity.HotSales) = with(binding) {
            badgeImageView.isVisible = item.isNew
            badgeTextView.isVisible = item.isNew
            productImageView.setImageGlide(url = item.imageUrl)
            brandTextView.text = item.brand
            descriptionTextView.text = item.discription
        }
    }
}