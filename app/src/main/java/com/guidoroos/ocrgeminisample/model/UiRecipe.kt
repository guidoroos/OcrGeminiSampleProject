package com.guidoroos.ocrgeminisample.model

import android.content.Context
import android.graphics.Bitmap
import com.guidoroos.ocrgeminisample.util.now
import kotlinx.datetime.LocalDateTime

data class UIRecipe(
    val id: Long? = null,
    val name: String = "New Recipe",
    val description: String = "",
    val cuisine: String = "",
    val createDate: LocalDateTime = LocalDateTime.now(),
    val updateDate: LocalDateTime = LocalDateTime.now(),
    val servings: Int = 4,
    val preparationMinutes: Int = 30,
    val encodedBitmap: Bitmap? = null,
    val isFavorite: Boolean = false,

    ) {
    companion object
}


fun UIRecipe.Companion.mock(context: Context): UIRecipe {
    return UIRecipe(
        name = "Mock Recipe",
        description = "Mock Description",
        cuisine = "Mock Cuisine",
        servings = 4,
        preparationMinutes = 30,
        encodedBitmap = null,
        isFavorite = false
    )
}

fun UIRecipe.Companion.mocks(context: Context): List<UIRecipe> {
    return listOf (
        UIRecipe(
            name = "Mock Recipe 1",
            description = "Mock Description 1",
            cuisine = "Mock Cuisine 1",
            servings = 4,
            preparationMinutes = 30,
            encodedBitmap = null,
            isFavorite = false
        ),
        UIRecipe(
            name = "Mock Recipe 2",
            description = "Mock Description 2",
            cuisine = "Mock Cuisine 2",
            servings = 4,
            preparationMinutes = 30,
            encodedBitmap = null,
            isFavorite = false
        ),
        UIRecipe(
            name = "Mock Recipe 3",
            description = "Mock Description 3",
            cuisine = "Mock Cuisine 3",
            servings = 4,
            preparationMinutes = 30,
            encodedBitmap = null,
            isFavorite = false
        )
    )
}


