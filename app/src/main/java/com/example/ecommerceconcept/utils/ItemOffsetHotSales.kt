package com.example.ecommerceconcept.utils

import android.content.Context
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetHotSales(private val context: Context): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        val offset = MARGIN.fromDpToPixels(context)
        val topOffset = MARGIN_TOP.fromDpToPixels(context)
        val bottomOffset = MARGIN_BOTTOM.fromDpToPixels(context)
        with(outRect){
            left = offset
            right = offset
            top = topOffset
            bottom = bottomOffset
        }
    }

    companion object{
        private const val MARGIN = 16
        private const val MARGIN_TOP = 8
        private const val MARGIN_BOTTOM = 10
    }
}