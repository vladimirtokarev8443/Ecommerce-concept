package com.example.ecommerceconcept.adapters.details

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.R
import com.example.ecommerceconcept.databinding.ItemShopBinding
import com.example.ecommerceconcept.models.DetailsSealed
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class DetailsShopAdapterDelegate:
    AbsListItemAdapterDelegate<DetailsSealed.Shop, DetailsSealed, DetailsShopAdapterDelegate.ShopHolder>(){

    override fun isForViewType(item: DetailsSealed, items: MutableList<DetailsSealed>, position: Int): Boolean {
        return item is DetailsSealed.Shop
    }

    override fun onCreateViewHolder(parent: ViewGroup): ShopHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemShopBinding.inflate(inflater, parent, false)
        return ShopHolder(binding)
    }

    override fun onBindViewHolder(item: DetailsSealed.Shop, holder: ShopHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class ShopHolder(val binding: ItemShopBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: DetailsSealed.Shop) = with(binding){
            cpuTextView.text = item.cpu
            cameraTextView.text = item.camera
            ssdTextView.text = item.ssd
            sdTextView.text = item.sd
            colorChipGroup.createColorChip(item.color)
            volumeChipGroup.createVolumeChip(item.capacity)

        }

        private fun ChipGroup.createColorChip(colors: List<String>){
            colors.forEachIndexed { index, color ->
                val colorInt = color.toColorInt()
                val colorStateList = ColorStateList.valueOf(colorInt)
                val chip = Chip(this.context).apply {
                    id = index
                    setChipBackgroundColorResource(R.color.white)
                    setChipStartPaddingResource(R.dimen.padding_zero)
                    setChipEndPaddingResource(R.dimen.padding_zero)
                    setTextStartPaddingResource(R.dimen.padding_zero)
                    setTextEndPaddingResource(R.dimen.padding_zero)
                    setChipIconResource(R.drawable.ic_select_color)
                    setChipIconSizeResource(R.dimen.chip_icon_size)
                    chipIconTint = colorStateList
                    isCheckable = true
                    isChecked = index == 0
                }
                this.addView(chip)
            }

        }
        private fun ChipGroup.createVolumeChip(capacities: List<String>){
            capacities.forEachIndexed { index, capacity ->
                val chip = Chip(this.context).apply {
                    id = index
                    setChipBackgroundColorResource(if (index == 0) R.color.orange else R.color.white)
                    setChipCornerRadiusResource(R.dimen.corner_radius_small)
                    isCheckedIconVisible = false
                    text = capacity
                    isCheckable = true
                    isChecked = index == 0
                    setOnCheckedChangeListener { buttonView, isChecked ->
                        setChipBackgroundColorResource(if (isChecked) R.color.orange else R.color.white)
                    }
                }
                this.addView(chip)
            }
        }
    }
}