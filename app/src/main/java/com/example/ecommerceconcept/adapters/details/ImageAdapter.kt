package com.example.ecommerceconcept.adapters.details

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.ItemImageBinding
import com.example.ecommerceconcept.utils.setImageGlide
import com.example.ecommerceconcept.utils.viewBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageHolder>() {

    private var items: List<String> = emptyList()

    fun updateItems(images: List<String>) {
        items = if (images.size == 2) images + images else images
        notifyItemRangeChanged(0, items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        return ImageHolder(parent.viewBinding(ItemImageBinding::inflate))
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ImageHolder(
        val binding: ItemImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl: String) {
            binding.imageView.setImageGlide(imageUrl)
        }
    }
}