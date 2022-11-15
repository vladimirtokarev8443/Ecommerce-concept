package com.example.ecommerceconcept.utils

import android.content.Context
import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetBasket(private val context: Context): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
        val offset = MARGIN.fromDpToPixels(context)
        val startEndOffset = MARGIN_START_END.fromDpToPixels(context)

        with(outRect){
            bottom = offset
            left = startEndOffset
            right = startEndOffset
        }
    }

    companion object{
        private const val MARGIN = 42
        private const val MARGIN_START_END = 32
    }
}