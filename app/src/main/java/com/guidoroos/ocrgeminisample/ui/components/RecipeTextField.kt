package com.guidoroos.ocrgeminisample.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guidoroos.ocrgeminisample.ui.theme.*

@Composable
fun RecipeTextField(
    text: String,
    textStyle: TextStyle,
    onClick: () -> Unit,
    backgroundColor: Color,
    textColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit = {},
    lines: Int = 1,
    shape: RoundedCornerShape = LocalShapes.current.small,
) {
    Box(
        modifier = modifier
            .clip(shape)
            .background(color = backgroundColor)
            .border(BorderStroke(1.dp, borderColor), shape)
            .clickable { onClick() }
            .padding(horizontal = 8.dp, vertical = 8.dp)

    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            icon() // Icon
            Text(
                text = text,
                color = textColor,
                style = textStyle,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = if (icon != {}) 8.dp else 0.dp), // Add left padding if icon is provided
                minLines = lines,
                maxLines = lines,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun PreviewRecipeNameTextField() {
    CookTheme {
        RecipeTextField(
            text = "recipeName",
            textStyle = LocalTypography.current.headlineMedium,
            onClick = {},
            backgroundColor = LocalColors.current.defaultBackground,
            borderColor = LocalColors.current.textFieldBorder,
            textColor = LocalColors.current.textFieldText

        )
    }
}

@Preview
@Composable
fun PreviewRecipeNameTextFieldIcon() {
    CookTheme {
        RecipeTextField(
            text = "recipeName",
            textStyle = LocalTypography.current.headlineMedium,
            onClick = {},
            backgroundColor = LocalColors.current.defaultBackground,
            borderColor = LocalColors.current.textFieldBorder,
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
            textColor = LocalColors.current.textFieldText

        )
    }
}

