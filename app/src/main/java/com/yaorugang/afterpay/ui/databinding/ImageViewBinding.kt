package com.yaorugang.afterpay.ui.databinding

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@BindingAdapter("imageUrl")
fun setImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        GlobalScope.launch(Dispatchers.IO) {
            val url = URL(imageUrl)
            val image = suspendCoroutine<Bitmap?> {
                try {
                    it.resume(BitmapFactory.decodeStream(url.openConnection().getInputStream()))
                } catch (e: Exception) {
                    it.resume(null)
                }
            }
            image?.let {
                withContext(Dispatchers.Main) {
                    imageView.setImageBitmap(it)
                }
            }
        }
    }
}

@BindingAdapter("imageRes")
fun setImage(imageView: ImageView, @DrawableRes imageRes: Int) {
    if (imageRes != 0) {
        imageView.setImageResource(imageRes)
    }
}