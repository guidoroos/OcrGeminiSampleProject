package com.guidoroos.ocrgeminisample.repository

import com.guidoroos.ocrgeminisample.model.UIFullRecipe
import com.guidoroos.ocrgeminisample.model.UIIngredient
import com.guidoroos.ocrgeminisample.model.UIRecipe
import com.guidoroos.ocrgeminisample.model.UIStep
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object RecipeRepository {

    private val _currentRecipe = MutableStateFlow<UIRecipe?>(null)
    val currentRecipe: StateFlow<UIRecipe?> get() = _currentRecipe

    private val _currentIngredients = MutableStateFlow<List<UIIngredient>>(emptyList())
    val currentIngredients: StateFlow<List<UIIngredient>> get() = _currentIngredients

    private val _currentSteps = MutableStateFlow<List<UIStep>>(emptyList())
    val currentSteps: StateFlow<List<UIStep>> get() = _currentSteps

    fun saveRecipe (fullRecipe: UIFullRecipe) {
        _currentRecipe.value = fullRecipe.recipe
        _currentIngredients.value = fullRecipe.ingredients
        _currentSteps.value = fullRecipe.steps
    }

}