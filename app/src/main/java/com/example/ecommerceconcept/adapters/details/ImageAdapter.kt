package com.example.ecommerceconcept.adapters.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.ItemImageBinding
import com.example.ecommerceconcept.utils.setImageGlide

class ImageAdapter(

): RecyclerView.Adapter<ImageAdapter.ImageHolder>() {

    private var items: List<String> = emptyList()

    fun updateItems(images: List<String>){
        items = if (images.size == 2) images+images else images
        notifyItemRangeChanged(0, items.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemImageBinding.inflate(inflater, parent, false)
        return ImageHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ImageHolder(
       val binding: ItemImageBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(imageUrl: String){
            binding.imageView.setImageGlide(imageUrl)
        }
    }
}