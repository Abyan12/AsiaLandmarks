package com.example.asialandmarks.domain

import android.graphics.Bitmap

interface landmarksClassifier {
    fun classify(bitmap: Bitmap, rotation: Int): List<Classification>
}