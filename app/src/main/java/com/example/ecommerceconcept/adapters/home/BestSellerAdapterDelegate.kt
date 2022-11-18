package com.example.ecommerceconcept.adapters.home

import android.graphics.Paint
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.BestSeller
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ItemBestSellerBinding
import com.example.ecommerceconcept.utils.setImageGlide
import com.example.ecommerceconcept.utils.viewBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BestSellerAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
): AbsListItemAdapterDelegate<BestSeller, BestSeller, BestSellerAdapterDelegate.BestSellerHolder>() {


    override fun isForViewType(
        item: BestSeller,
        items: MutableList<BestSeller>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): BestSellerHolder {
        return BestSellerHolder(parent.viewBinding(ItemBestSellerBinding::inflate), onItemClicked)
    }

    override fun onBindViewHolder(
        item: BestSeller,
        holder: BestSellerHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class BestSellerHolder(
        val binding: ItemBestSellerBinding,
        private val onItemClicked: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(binding.root){

        init {
            binding.root.setOnClickListener {
                onItemClicked(1)
            }
        }

        fun bind(item: BestSeller) = with(binding){
            var isSelect = item.favorites

            productImageView.setImageGlide(item.imageUrl)

            brandTextView.text = item.title

            discountPriceTextView.text = itemView.resources.getString(R.string.price_with_usd, item.priceDiscount)

            priceTextView.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            priceTextView.text = item.price.toString()

            favoritesImageView.setIconFavorites(isSelect)
            containerCardView.setOnClickListener {
                isSelect = isSelect.not()
                favoritesImageView.setIconFavorites(isSelect)
            }
        }

        private fun ImageView.setIconFavorites(isSelect: Boolean){
            val icon = if (isSelect) R.drawable.ic_favorites_selected else R.drawable.ic_favorites
            setImageResource(icon)
        }
    }
}