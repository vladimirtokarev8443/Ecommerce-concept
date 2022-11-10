package com.example.ecommerceconcept.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.BestSeller
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ItemBestSellerPhoneBinding
import com.example.ecommerceconcept.models.RecyclerItems
import com.example.ecommerceconcept.utils.setImageGlide
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ItemBestSellerAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
): AbsListItemAdapterDelegate<RecyclerItems.Phone, RecyclerItems, ItemBestSellerAdapterDelegate.PhonesHolder>() {


    override fun isForViewType(
        item: BestSeller,
        items: MutableList<BestSeller>,
        position: Int
    ): Boolean {
        return item is BestSeller
    }

    override fun onCreateViewHolder(parent: ViewGroup): PhonesHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBestSellerPhoneBinding.inflate(inflater, parent,false)
        return PhonesHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(
        item: BestSeller,
        holder: PhonesHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class PhonesHolder(
        val binding: ItemBestSellerPhoneBinding,
        private val onItemClicked: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: BestSeller){
            binding.productImageView.setImageGlide(item.imageUrl)
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