package com.example.ecommerceconcept.utils

import android.content.Context
import android.graphics.Rect
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetDecoration(private val context: Context): RecyclerView.ItemDecoration() {
    //метод класса ItemDecoration задает отступы с какой стороны и на сколько надо
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        //определяем отступ с каждой стороны
        val offset = 23.fromDpToPixels(context)
        with(outRect){
            left =offset
            right = offset
            top = offset
            bottom = offset
        }
    }

    //сделаем экстенсион метод для перевода из dp в pixels.
    // В этом методе получим доступ к плотности нашего экрана, для этого нужно
    //получить доступ к контексту
    // разделим плотность нашего экрана на плотность стандартного экрана
    private fun Int.fromDpToPixels(context: Context): Int {
        val density = context.resources.displayMetrics.densityDpi
        val pixelInDp = density / DisplayMetrics.DENSITY_DEFAULT
        return this * pixelInDp
    }
}