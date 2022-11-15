package com.example.ecommerceconcept.utils

import android.content.Context
import android.util.DisplayMetrics
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.domain.models.DetailsProduct
import com.example.ecommerceconcept.models.DetailsSealed
import java.util.*

fun ImageView.setImageGlide(url: String){
     Glide.with(this).load(url).into(this)
 }

fun Int.fromDpToPixels(context: Context): Int {
    val density = context.resources.displayMetrics.densityDpi
    val pixelInDp = density / DisplayMetrics.DENSITY_DEFAULT
    return this * pixelInDp
}

fun DetailsProduct.getShop(id: Int): DetailsSealed.Shop{
    return DetailsSealed.Shop(id, cpu, camera, sd, ssd, capacity, color)
}