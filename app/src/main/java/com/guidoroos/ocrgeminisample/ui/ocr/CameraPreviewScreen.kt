package com.guidoroos.ocrgeminisample.ui.ocr

import android.content.Context
import androidx.annotation.OptIn
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.mlkit.vision.common.InputImage
import com.guidoroos.ocrgeminisample.ui.components.ActionButton
import com.guidoroos.ocrgeminisample.ui.components.ButtonType
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

@Composable
fun CameraPreviewScreen(
    isLoading: Boolean,
    onCaptureImage: (InputImage?) -> Unit

) {
    val lensFacing = CameraSelector.LENS_FACING_BACK
    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current
    val context = LocalContext.current
    val preview = Preview.Builder().build()
    val previewView = remember {
        PreviewView(context)
    }
    val cameraxSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
    val imageCapture = remember {
        ImageCapture.Builder().build()
    }
    val scope = rememberCoroutineScope()


    LaunchedEffect(lensFacing) {
        val cameraProvider = context.getCameraProvider(scope)
        cameraProvider.unbindAll()
        cameraProvider.bindToLifecycle(lifecycleOwner, cameraxSelector, preview, imageCapture)
        preview.surfaceProvider = previewView.surfaceProvider
    }
    Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
        AndroidView({ previewView }, modifier = Modifier.fillMaxSize())
        ActionButton(
            enabled = !isLoading,
            onClick = {
                captureImage(
                    imageCapture = imageCapture,
                    context = context,
                    onCaptureImage = onCaptureImage
                )
            },
            text = stringResource(id = R.string.capture_image),
            type = ButtonType.PRIMARY,
            modifier = Modifier.padding(all = LocalDimens.current.spacing3)
        )
    }
}

private fun captureImage(
    imageCapture: ImageCapture,
    context: Context,
    onCaptureImage: (InputImage?) -> Unit
) {
    imageCapture.takePicture(
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageCapturedCallback() {
            override fun onCaptureSuccess(imageProxy: ImageProxy) {
                onCaptureImage(imageProxy.toInputImage())

                imageProxy.close()
            }

            override fun onError(exception: ImageCaptureException) {
                println("Failed $exception")
            }
        }
    )
}

@OptIn(ExperimentalGetImage::class)
private fun ImageProxy.toInputImage(): InputImage? {

    return image?.let { InputImage.fromMediaImage(it, imageInfo.rotationDegrees) }
}

private suspend fun Context.getCameraProvider(scope: CoroutineScope): ProcessCameraProvider =
    suspendCoroutine { continuation ->
        ProcessCameraProvider.getInstance(this).also { cameraProvider ->
            cameraProvider.addListener({
                scope.launch {
                    try {
                        val provider = withContext(Dispatchers.IO) {
                            cameraProvider.get()
                        }
                        continuation.resume(provider)
                    } catch (e: Exception) {
                        continuation.resumeWithException(e)
                    }
                }
            }, ContextCompat.getMainExecutor(this))
        }
    }