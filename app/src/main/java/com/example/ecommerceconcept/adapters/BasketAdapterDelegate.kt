package com.example.ecommerceconcept.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Basket
import com.example.ecommerceconcept.databinding.ItemBasketBinding
import com.example.ecommerceconcept.utils.setImageGlide
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BasketAdapterDelegate :
    AbsListItemAdapterDelegate<Basket, Basket, BasketAdapterDelegate.BasketHolder>(){

    override fun isForViewType(item: Basket, items: MutableList<Basket>, position: Int): Boolean = true

    override fun onCreateViewHolder(parent: ViewGroup): BasketHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBasketBinding.inflate(inflater, parent, false)
        return BasketHolder(binding)
    }

    override fun onBindViewHolder(item: Basket, holder: BasketHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class BasketHolder(val binding: ItemBasketBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: Basket){
            binding.productImageView.setImageGlide(item.imageUrl)
            binding.titleTextView.text = item.title
            binding.priceTextView.text = item.price.toString()
            binding.minusImageView.setOnClickListener {
                var count = binding.countTextView.text.toString().toInt()
                if (count > 0) count -= 1
                binding.countTextView.text = count.toString()
            }
            binding.plusImageView.setOnClickListener {
                var count = binding.countTextView.text.toString().toInt()
                count += 1
                binding.countTextView.text = count.toString()
            }
            binding.deleteImageView.setOnClickListener {

            }
        }
    }
}