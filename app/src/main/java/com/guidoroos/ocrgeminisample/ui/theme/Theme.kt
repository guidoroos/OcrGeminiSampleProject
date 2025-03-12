package com.guidoroos.ocrgeminisample.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

// Define CompositionLocals
val LocalShapes = compositionLocalOf<Shape> { error("No Shapes provided") }
val LocalTypography = compositionLocalOf<Typography> { error("No Typography provided") }
val LocalColors = compositionLocalOf<CustomColors> { error("No CustomColors provided") }
val LocalDimens = compositionLocalOf<DimenSet> { error("No Dimens provided") }

@Composable
fun CustomThemeProvider(
    shapes: Shape,
    typography: Typography,
    customColors: CustomColors,
    dimens: DimenSet,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalShapes provides shapes,
        LocalTypography provides typography,
        LocalColors provides customColors,
        LocalDimens provides dimens
    ) {
        MaterialTheme(
            content = content,
            colorScheme = MaterialTheme.colorScheme.copy(
                background = customColors.defaultBackground,
            )
        )
    }
}

@Composable
fun CookTheme(
    content: @Composable () -> Unit
) {
    // Access theme properties using CompositionLocal
    CustomThemeProvider(
        shapes = Shape(),
        typography = TextStyle().typography,
        customColors = ColorSet().customColors,
        dimens = Dimens().spacing
    ) {
        content()
    }
}



