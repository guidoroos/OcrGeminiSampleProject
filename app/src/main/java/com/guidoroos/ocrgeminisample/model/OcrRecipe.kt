package com.guidoroos.ocrgeminisample.model

data class OcrRecipe(
    val name: String,
    val description: String? = null,
    val cuisine: String? = null,
    val servings: String? = null,
    val preparationMinutes: String? = null,
    val steps: List<OcrStep> = emptyList(),
    val ingredients: List<OcrIngredient> = emptyList()
)

data class OcrIngredient(
    val amount: String? = null,
    val measure: String? = null,
    val denominator: String? = null,
    val name: String
)

data class OcrStep(
    val description: String,
    val timeSeconds: Long? = null
)