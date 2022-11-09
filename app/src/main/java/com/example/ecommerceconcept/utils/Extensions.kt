package com.example.ecommerceconcept.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide

fun ImageView.setImageGlide(url: String){
     Glide.with(this).load(url).into(this)
 }

fun Int.fromDpToPixels(context: Context): Int {
    val density = context.resources.displayMetrics.densityDpi
    val pixelInDp = density / DisplayMetrics.DENSITY_DEFAULT
    return this * pixelInDp
}