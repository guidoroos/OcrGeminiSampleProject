package com.guidoroos.ocrgeminisample.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.guidoroos.ocrgeminisample.R

val merriweatherFontFamily = FontFamily(
    Font(R.font.merriweather_black, FontWeight.Black),
    Font(R.font.merriweather_blackitalic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.merriweather_bold, FontWeight.Bold),
    Font(R.font.merriweather_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.merriweather_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.merriweather_light, FontWeight.Light),
    Font(R.font.merriweather_lightitalic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.merriweather_regular, FontWeight.Normal)
)


object TextSize {
    val S = 12.sp
    val M = 14.sp
    val L = 20.sp
    val XL = 28.sp
    val XXL = 36.sp
    val XXXL = 48.sp
    val H = 60.sp
    val G = 72.sp
}

data class TextStyle(
    val typography: Typography = Typography(
        displayLarge = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = TextSize.G
        ),
        displayMedium = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = TextSize.H
        ),
        displaySmall = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = TextSize.XL
        ),
        headlineLarge = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TextSize.XXL
        ),
        headlineMedium = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TextSize.XL
        ),
        headlineSmall = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TextSize.L
        ),
        titleLarge = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.M
        ),
        titleMedium = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.M
        ),
        titleSmall = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.S
        ),
        bodyLarge = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.M
        ),
        bodyMedium = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.S
        ),
        bodySmall = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = TextSize.S
        ),
        labelLarge = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TextSize.M
        ),
        labelMedium = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TextSize.S
        ),
        labelSmall = TextStyle(
            fontFamily = merriweatherFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = TextSize.S
        )
    )
)