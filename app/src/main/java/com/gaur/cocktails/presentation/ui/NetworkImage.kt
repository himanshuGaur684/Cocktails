package com.gaur.cocktails.presentation.ui

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.gaur.cocktails.R


@Composable
fun NetworkImage(url: String, @DrawableRes d: Int): MutableState<Bitmap?> {
    val image = remember { mutableStateOf<Bitmap?>(null) }
    Glide.with(LocalContext.current).setDefaultRequestOptions(
        RequestOptions.placeholderOf(d).error(
            R.drawable.drink_placeholder
        )
    )
        .asBitmap().load(url).into(object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                image.value = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {

            }
        })
    return image
}