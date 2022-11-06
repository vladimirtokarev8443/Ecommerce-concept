package com.example.ecommerceconcept.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Category
import com.example.domain.models.Entity
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ItemSelectCategoryBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class CategoryAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
) : AbsListItemAdapterDelegate<Category, Category, CategoryAdapterDelegate.CategoryHolder>() {

    override fun isForViewType(item: Category, items: MutableList<Category>, position: Int): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): CategoryHolder {
        val inflater =  LayoutInflater.from(parent.context)
        val binding = ItemSelectCategoryBinding.inflate(inflater, parent, false)
        return CategoryHolder(binding, onItemClicked)
    }

    override fun onBindViewHolder(
        item: Category,
        holder: CategoryHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class CategoryHolder(
        val binding: ItemSelectCategoryBinding,
        private val onItemClicked: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(binding.root){


        fun bind(item: Category){
            binding.badgeImageView.setImageResource(item.badgeImage)
            binding.categoryNameTextView.text = item.title

            if (item.isClick){
                binding.cardView.setCardBackgroundColor(itemView.context.getColor(R.color.purple_500))
                binding.categoryNameTextView.setTextColor(itemView.context.getColor(R.color.purple_500))
                binding.badgeImageView.setColorFilter(itemView.context.getColor(R.color.white))
            } else {
                binding.cardView.setCardBackgroundColor(itemView.context.getColor(R.color.white))
                binding.categoryNameTextView.setTextColor(itemView.context.getColor(R.color.black))
                binding.badgeImageView.setColorFilter(itemView.context.getColor(R.color.icon_color))
            }

            binding.root.setOnClickListener {
                onItemClicked(item.id)
            }

        }
    }
}