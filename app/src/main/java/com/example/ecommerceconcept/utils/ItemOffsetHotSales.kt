package com.example.ecommerceconcept.utils

import android.content.Context
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetHotSales(private val context: Context): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        val offset = MARGIN.fromDpToPixels(context)
        with(outRect){
            left = offset
            right = offset
        }
    }

    companion object{
        private const val MARGIN = 16
    }
}