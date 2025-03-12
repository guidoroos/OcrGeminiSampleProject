package com.guidoroos.ocrgeminisample.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class DimenSet(
    val spacing1: Dp,
    val spacing2: Dp,
    val spacing3: Dp,
    val spacing4: Dp,
    val spacing5: Dp,
    val spacing6: Dp,
    val spacing7: Dp,
    val spacing8: Dp,
    val spacing10: Dp,
    val spacing12: Dp,
    val spacing15: Dp,
    val spacing20: Dp,
    val spacing25: Dp,
    val spacing30: Dp,
    val spacing40: Dp
)

data class Dimens(
    val spacing: DimenSet = DimenSet(
        spacing1 = 4.dp,
        spacing2 = 8.dp,
        spacing3 = 12.dp,
        spacing4 = 16.dp,
        spacing5 = 20.dp,
        spacing6 = 24.dp,
        spacing7 = 28.dp,
        spacing8 = 32.dp,
        spacing10 = 40.dp,
        spacing12 = 48.dp,
        spacing15 = 60.dp,
        spacing20 = 80.dp,
        spacing25 = 100.dp,
        spacing30 = 120.dp,
        spacing40 = 160.dp
    )
)
