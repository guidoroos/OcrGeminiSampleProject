package com.guidoroos.ocrgeminisample.model


data class UIFullRecipe (
    val recipe: UIRecipe,
    val ingredients: List<UIIngredient>,
    val steps: List<UIStep>
)