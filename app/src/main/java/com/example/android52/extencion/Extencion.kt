package com.example.rickandmorty3.extencion

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.rickandmorty3.R

fun View.glide(url: String){
    Glide.with(this).load(url).placeholder(R.drawable.rick).circleCrop().into(this as ImageView)
}
fun Fragment.makeToast(text:String){
    Toast.makeText(requireContext(),text, Toast.LENGTH_SHORT).show()
}
fun Context.makeToast(text:String){
    Toast.makeText(applicationContext,text, Toast.LENGTH_SHORT).show()
}