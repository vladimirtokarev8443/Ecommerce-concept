package com.example.ecommerceconcept.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.BestSeller
import com.example.ecommerceconcept.databinding.ItemBestSellerBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BestSellerPhoneAdapterDelegate(
    private val onItemClicked: (position: Int) -> Unit
): AbsListItemAdapterDelegate<BestSeller.Phones, BestSeller, BestSellerPhoneAdapterDelegate.PhonesHolder>() {


    override fun isForViewType(
        item: BestSeller,
        items: MutableList<BestSeller>,
        position: Int
    ): Boolean {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup): PhonesHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        item: BestSeller.Phones,
        holder: PhonesHolder,
        payloads: MutableList<Any>
    ) {
        TODO("Not yet implemented")
    }

    class PhonesHolder(
        val binding: ItemBestSellerBinding,
        private val onItemClicked: (position: Int) -> Unit
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: BestSeller.Phones){}
    }
}