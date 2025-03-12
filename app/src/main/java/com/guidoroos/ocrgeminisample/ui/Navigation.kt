package com.guidoroos.ocrgeminisample.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.guidoroos.ocrgeminisample.ui.screen.ocr.OcrCaptureScreen
import com.guidoroos.ocrgeminisample.ui.recipe.RecipeBaseScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationPage.OcrCapture.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable (
            route = NavigationPage.Recipe.route
        ) {
            RecipeBaseScreen(
                navController = navController
            )
        }

        composable (
            route = NavigationPage.OcrCapture.route
        ) {
            OcrCaptureScreen(
                navController = navController
            )
        }
    }
}

enum class NavigationPage(
    val route: String
) {
    OcrCapture("ocr_recipe"),
    Recipe("recipe"),
}