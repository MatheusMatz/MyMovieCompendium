package com.sentinel.core.ext

import androidx.appcompat.widget.AppCompatImageView
import coil.load

fun AppCompatImageView.loadImage(path: String) {
    this.load("https://image.tmdb.org/t/p/w185/${path}") {
        crossfade(550)
        build()
    }

}
