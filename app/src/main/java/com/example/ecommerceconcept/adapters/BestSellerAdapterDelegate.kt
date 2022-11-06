package com.example.ecommerceconcept.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Entity
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ItemBestSellerBinding
import com.example.ecommerceconcept.utils.setImageGlide
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BestSellerAdapterDelegate :
AbsListItemAdapterDelegate<Entity.BestSeller, Entity, BestSellerAdapterDelegate.BestSellerHolder>(){

    override fun isForViewType(item: Entity, items: MutableList<Entity>, position: Int): Boolean {
        return item is Entity.BestSeller
    }

    override fun onCreateViewHolder(parent: ViewGroup): BestSellerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBestSellerBinding.inflate(inflater, parent, false)
        return BestSellerHolder(binding)
    }

    override fun onBindViewHolder(
        item: Entity.BestSeller,
        holder: BestSellerHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class BestSellerHolder(
        val binding: ItemBestSellerBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Entity.BestSeller){
            binding.productImageView.setImageGlide(item.productImage)
            binding.productTextView.text = item.title
            binding.discountTextView.text = item.priceDiscount.toString()
            binding.priceTextView.text = item.price.toString()
            if (item.favorites){
                binding.favoritesImageView.setImageResource(R.drawable.ic_favorites__selected)
            } else {
                binding.favoritesImageView.setImageResource(R.drawable.ic_favorites)
            }
        }
    }
}