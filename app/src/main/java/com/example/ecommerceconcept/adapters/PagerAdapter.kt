package com.example.ecommerceconcept.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Entity
import com.example.domain.models.HotSales
import com.example.ecommerceconcept.databinding.ItemHotSalesBinding
import com.example.ecommerceconcept.utils.setImageGlide

//class PagerAdapter(
//    private val onItemClicked: (position: Int) -> Unit
//) : RecyclerView.Adapter<PagerAdapter.PagerHolder>() {
//    var items = emptyList<Entity>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = ItemHotSalesBinding.inflate(inflater, parent, false)
//        return PagerHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: PagerHolder, position: Int) {
//        holder.bind(item = items[position] as Entity.HotSales)
//    }
//
//    override fun getItemCount(): Int = items.size
//
//    class PagerHolder(
//        val binding: ItemHotSalesBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(item: Entity.HotSales) = with(binding) {
//            badgeImageView.isVisible = item.isNew
//            badgeTextView.isVisible = item.isNew
//            productImageView.setImageGlide(url = item.imageUrl)
//            brandTextView.text = item.brand
//            descriptionTextView.text = item.discription
//        }
//
//    }
//
//}