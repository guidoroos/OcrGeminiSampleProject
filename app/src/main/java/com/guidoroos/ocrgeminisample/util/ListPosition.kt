package com.guidoroos.ocrgeminisample.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import com.guidoroos.ocrgeminisample.ui.theme.LocalShapes

enum class ListPosition {
    Only,
    First,
    Last,
    Middle;

    companion object {
        fun from(index: Int, size: Int): ListPosition {
            return when {
                size == 1 -> Only
                index == 0 -> First
                index == size - 1 -> Last
                else -> Middle
            }
        }

        @Composable
        fun ListPosition.shape() = when (this) {
            Only -> LocalShapes.current.medium
            First -> LocalShapes.current.topOnlyMedium
            Last -> LocalShapes.current.bottomOnlyMedium
            Middle -> RectangleShape
        }
    }
}
