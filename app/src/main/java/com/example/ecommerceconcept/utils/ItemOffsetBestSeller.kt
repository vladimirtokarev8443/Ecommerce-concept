package com.example.ecommerceconcept.utils

import android.content.Context
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetBestSeller(private val context: Context): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        val offset = MARGIN.fromDpToPixels(context)
        val offsetStart = MARGIN_START.fromDpToPixels(context)
        val offsetEnd = MARGIN_END.fromDpToPixels(context)
        with(outRect){
            left = if (itemPosition %2 == 0) offsetStart else offset
            right = if (itemPosition %2 != 0) offsetEnd else offset
            top = offset
            bottom = offset
        }

    }

    companion object{
        private const val MARGIN_START = 16
        private const val MARGIN_END = 16
        private const val MARGIN = 7
    }
}