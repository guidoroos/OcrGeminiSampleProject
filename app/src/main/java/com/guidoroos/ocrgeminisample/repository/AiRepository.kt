package com.guidoroos.ocrgeminisample.repository

import android.util.Log
import com.google.ai.client.generativeai.GenerativeModel
import com.guidoroos.ocrgeminisample.model.UIFullRecipe
import com.guidoroos.ocrgeminisample.util.ResultOf
import com.guidoroos.ocrgeminisample.BuildConfig
import com.guidoroos.ocrgeminisample.util.geminiPrompt
import com.guidoroos.ocrgeminisample.R
import com.guidoroos.ocrgeminisample.model.OcrRecipe
import com.guidoroos.ocrgeminisample.model.UIIngredient
import com.guidoroos.ocrgeminisample.model.UIRecipe
import com.guidoroos.ocrgeminisample.model.UIStep
import com.guidoroos.ocrgeminisample.util.OcrRecipeDeserializer
import com.google.gson.GsonBuilder

object AIRepository {
    suspend fun processOcrTextAndSaveRecipe(extractedText: List<String>): ResultOf<UIFullRecipe> {
        if (extractedText.isEmpty()) {
            return ResultOf.Error(R.string.error_empty_ocr_text)
        }

        val totalText = extractedText.joinToString("\n")

        val generativeModel = GenerativeModel(
            modelName = "gemini-1.5-pro-latest",
            apiKey = BuildConfig.AI_KEY
        )

        val response = generativeModel.generateContent(
            geminiPrompt(
                scan = totalText
            )
        )
        Log.i(this::class.simpleName, "Response: ${response.text}")

        if (response.text == "not a recipe") {
            return ResultOf.Error(R.string.error_not_a_recipe)
        }

        val recipeJson = response.text?.trim()

        //gemini has a habit of doing this
        val correctedJson = recipeJson?.let {
            if (it.startsWith("```json") && it.endsWith("```")) {
                it.substring(7, it.length - 3).trim()
            } else {
                it
            }
        }

        val gson = GsonBuilder()
            .registerTypeAdapter(OcrRecipe::class.java, OcrRecipeDeserializer())
            .create()

        val ocrRecipe = gson.fromJson(correctedJson, OcrRecipe::class.java)

        val newRecipe = UIRecipe(
            name = ocrRecipe.name,
            description = ocrRecipe.description ?: "",
            cuisine = ocrRecipe.cuisine ?: "",
            servings = ocrRecipe.servings?.toIntOrNull() ?: 0,
            preparationMinutes = ocrRecipe.preparationMinutes?.toIntOrNull() ?: 0
        )
        val newIngredients = ocrRecipe.ingredients.mapIndexed { index, item ->
            UIIngredient(
                amount = item.amount?.toFloatOrNull(),
                denominator = item.denominator?.toIntOrNull(),
                measure = item.measure,
                name = item.name,
                recipeId = null,
                position = index
            )
        }
        val newSteps = ocrRecipe.steps.mapIndexed { index, item ->
            UIStep(
                description = item.description,
                timeSeconds = item.timeSeconds,
                recipeId = null,
                position = index
            )
        }

        return ResultOf.Success(UIFullRecipe(newRecipe, newIngredients, newSteps))
    }
}