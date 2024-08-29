package com.example.asialandmarks.presentation

import android.graphics.Bitmap

fun Bitmap.centerCrop(desireWidth: Int, desireHeight: Int): Bitmap {
    val xStart = (width - desireWidth) / 2
    val yStart = (height - desireHeight) / 2

    if(xStart < 0 || yStart < 0 || desireWidth > width || desireHeight > height) {
        throw IllegalArgumentException("Crop rectangle does not fit within bitmap.")
    }

    return Bitmap.createBitmap(this, xStart, yStart, desireWidth, desireHeight)

}