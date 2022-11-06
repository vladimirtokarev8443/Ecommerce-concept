package com.example.ecommerceconcept.utils

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class AnimePageTransformer: ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        when{
            position < -1 || position > 1 -> {
                page.alpha = 0f
            }
            position <= 0 -> {
                page.alpha = 1 + position
            }
            position <= 1 -> {
                page.alpha = 1 - position
            }
        }
    }
}
