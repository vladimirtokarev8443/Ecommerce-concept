package com.example.ecommerceconcept.utils

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class ZoomOutTransformation: ViewPager2.PageTransformer {


    override fun transformPage(page: View, position: Float) {
        if (position <= 1) {
            page.scaleX = Math.max(MIN_SCALE, 1 - Math.abs(position))
            page.scaleY = Math.max(MIN_SCALE, 1 - Math.abs(position))
        }

    }

    companion object{
        const val MIN_SCALE = 0.65f
        const val MIN_ALPHA = 0.3f
    }

}