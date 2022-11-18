package com.example.ecommerceconcept.adapters.home

import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.HotSales
import com.example.ecommerceconcept.databinding.ItemHotSalesBinding
import com.example.ecommerceconcept.utils.setImageGlide
import com.example.ecommerceconcept.utils.viewBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HotSalesAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
) : AbsListItemAdapterDelegate<HotSales, HotSales, HotSalesAdapterDelegate.HotSalesHolder>() {


    override fun isForViewType(
        item: HotSales,
        items: MutableList<HotSales>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): HotSalesHolder {
        return HotSalesHolder(parent.viewBinding(ItemHotSalesBinding::inflate), onItemClicked)
    }

    override fun onBindViewHolder(
        item: HotSales,
        holder: HotSalesHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class HotSalesHolder(
        val binding: ItemHotSalesBinding,
        private val onItemClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HotSales) = with(binding) {
            badgeImageView.isVisible = item.isNew
            badgeTextView.isVisible = item.isNew
            productImageView.setImageGlide(url = item.imageUrl)
            brandTextView.text = item.brand
            descriptionTextView.text = item.discription

            binding.buyNowButton.setOnClickListener { onItemClicked(item.id) }
        }

    }
}