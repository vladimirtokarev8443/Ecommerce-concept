package com.example.ecommerceconcept.adapters.home

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Category
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ItemCategoryBinding
import com.example.ecommerceconcept.utils.viewBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class CategoryAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
) : AbsListItemAdapterDelegate<Category, Category, CategoryAdapterDelegate.CategoryHolder>() {

    override fun isForViewType(
        item: Category,
        items: MutableList<Category>,
        position: Int
    ): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup): CategoryHolder {
        return CategoryHolder(parent.viewBinding(ItemCategoryBinding::inflate), onItemClicked)
    }

    override fun onBindViewHolder(
        item: Category,
        holder: CategoryHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }

    class CategoryHolder(
        val binding: ItemCategoryBinding,
        private val onItemClicked: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(item: Category) {
            binding.categoryIconImageView.setImageResource(item.iconRes)
            binding.categoryNameTextView.text = item.title

            if (item.isClick) {
                binding.containerCardView.setCardBackgroundColor(itemView.context.getColor(R.color.orange))
                binding.categoryNameTextView.setTextColor(itemView.context.getColor(R.color.orange))
                binding.categoryIconImageView.setColorFilter(itemView.context.getColor(R.color.white))
            } else {
                binding.containerCardView.setCardBackgroundColor(itemView.context.getColor(R.color.white))
                binding.categoryNameTextView.setTextColor(itemView.context.getColor(R.color.black))
                binding.categoryIconImageView.setColorFilter(itemView.context.getColor(R.color.icon_color))
            }

            binding.root.setOnClickListener {
                onItemClicked(item.id)
            }

        }
    }
}