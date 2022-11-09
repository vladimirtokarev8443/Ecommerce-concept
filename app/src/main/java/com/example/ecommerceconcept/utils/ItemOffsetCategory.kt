package com.example.ecommerceconcept.utils

import android.content.Context
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetCategory(private val context: Context): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        val offset = MARGIN.fromDpToPixels(context)
        val offsetStart = MARGIN_START.fromDpToPixels(context)
            with(outRect){
                left = if (itemPosition == 0) offsetStart else offset
                right = offset
                top = offset
                bottom = offset
            }
        }

    companion object{
        private const val MARGIN_START = 27
        private const val MARGIN = 12
    }
}