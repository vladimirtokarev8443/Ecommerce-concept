package com.example.ecommerceconcept.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide

fun ImageView.setImageGlide(url: String){
     Glide.with(this).load(url).into(this)
 }