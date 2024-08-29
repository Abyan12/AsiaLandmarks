package com.example.asialandmarks.presentation

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.asialandmarks.datas.TensorFlowLiteLandmarksClassifier
import com.example.asialandmarks.domain.Classification

class landmarksImgAnalyzer(
    private val classifier: TensorFlowLiteLandmarksClassifier,
    private val onResults: (List<Classification>) -> Unit
): ImageAnalysis.Analyzer {

    private var frameSkipCounter = 0

    override fun analyze(image: ImageProxy) {
        if(frameSkipCounter % 60 == 0) {
            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image
                .toBitmap()
                .centerCrop(321, 321)

            val results = classifier.classify(bitmap, rotationDegrees)
            onResults(results)
        }

        image.close()
    }
}