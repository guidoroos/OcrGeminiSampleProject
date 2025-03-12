package com.guidoroos.ocrgeminisample.ui.recipe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.mlkit.vision.common.InputImage
import com.guidoroos.ocrgeminisample.repository.OcrRepository
import com.guidoroos.ocrgeminisample.repository.RecipeRepository
import com.guidoroos.ocrgeminisample.util.ResultOf
import com.guidoroos.ocrgeminisample.R
import com.guidoroos.ocrgeminisample.model.UIFullRecipe
import com.guidoroos.ocrgeminisample.repository.AIRepository
import com.guidoroos.ocrgeminisample.util.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel  : ViewModel() {
    val recipeState = RecipeRepository.currentRecipe
    val stepsState = RecipeRepository.currentSteps
    val ingredientsState = RecipeRepository.currentIngredients

    private val _imageTextState = MutableStateFlow<ResultOf<String>>(ResultOf.None)
    val imageTextState: StateFlow<ResultOf<String>> = _imageTextState

    private val _saveRecipeState = MutableStateFlow<ResultOf<UIFullRecipe>>(ResultOf.None)
    val saveRecipeState: StateFlow<ResultOf<UIFullRecipe>> = _saveRecipeState

    var extractedText = emptyList<String>()
        private set

    fun extractTextFromImage(image: InputImage?) = viewModelScope.launch(
        Dispatchers.IO + CoroutineExceptionHandler { _, exception ->
            Log.e(this::class.simpleName, exception.message ?: "")
            _imageTextState.value = ResultOf.Error(R.string.error_ocr_text_extraction_failed)
        }
    ) {
        _imageTextState.value = ResultOf.Loading

        if (image == null) {
            _imageTextState.value = ResultOf.Error(R.string.error_message_image_not_found)
            return@launch
        }

        OcrRepository.processImage(image).let { result ->
            when (result) {
                is ResultOf.Success -> {
                    _imageTextState.value = ResultOf.Success(result.data)
                    extractedText += result.data
                }

                else -> {
                    _imageTextState.value =
                        ResultOf.Error(R.string.error_ocr_text_extraction_failed)
                }
            }
        }
    }

    fun processOcrTextAndSaveRecipe() = viewModelScope.launch(
        Dispatchers.IO + geminiExceptionHandler(
            tag = this::class.simpleName,
            state = _saveRecipeState
        )
    ) {
        _saveRecipeState.value = ResultOf.Loading

        val result = AIRepository.processOcrTextAndSaveRecipe(extractedText)
        if (result is ResultOf.Success) {
            RecipeRepository.saveRecipe(result.data)
        }

        _saveRecipeState.value = result
    }

    fun resetImageTextState() {
        _imageTextState.value = ResultOf.None
    }

    fun deleteLastOcrText() {
        extractedText = extractedText.dropLast(1)
    }

    fun resetSaveState() {
        _saveRecipeState.value = ResultOf.None
        extractedText = emptyList()
    }

}
