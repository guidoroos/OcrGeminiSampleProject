package com.guidoroos.ocrgeminisample.repository

import android.util.Log
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import com.guidoroos.ocrgeminisample.util.ResultOf
import com.guidoroos.ocrgeminisample.R
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

object OcrRepository {
    private val textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

    suspend fun processImage(inputImage: InputImage): ResultOf<String> {
        return suspendCancellableCoroutine { continuation ->
            textRecognizer.process(inputImage)
                .addOnSuccessListener { visionText ->
                    val result = ResultOf.Success(visionText.text)
                    continuation.resume(result)
                }
                .addOnFailureListener { e ->
                    Log.e(this::class.simpleName, e.stackTrace.toString())
                    continuation.resume(ResultOf.Error(R.string.ocr_processing_failed))
                }
        }
    }

}