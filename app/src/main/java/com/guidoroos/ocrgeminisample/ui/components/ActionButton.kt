package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalShapes
import com.guidoroos.ocrgeminisample.ui.theme.LocalTypography
import com.guidoroos.ocrgeminisample.ui.theme.CookTheme

enum class ButtonType {
    PRIMARY,
    SECONDARY,
    TERTIARY,
    NEGATIVE,
    TEXTONLY;

    @Composable
    fun backgroundColor() = when (this) {
        PRIMARY -> LocalColors.current.primaryButtonColor
        SECONDARY -> LocalColors.current.secondaryButtonColor
        NEGATIVE -> LocalColors.current.cancelButtonColor
        TERTIARY -> LocalColors.current.tertiaryButtonColor
        TEXTONLY -> Color.Transparent
    }

    @Composable
    fun textColor() = when (this) {
        PRIMARY -> LocalColors.current.primaryButtonTextColor
        SECONDARY -> LocalColors.current.secondaryButtonTextColor
        NEGATIVE -> LocalColors.current.cancelButtonTextColor
        TERTIARY -> LocalColors.current.tertiaryButtonTextColor
        TEXTONLY -> LocalColors.current.textFieldText
    }
}

@Composable
fun ActionButton(
    text: String,
    modifier: Modifier = Modifier,
    type: ButtonType,
    enabled: Boolean = true,
    height: Dp = 48.dp,
    shape: Shape = LocalShapes.current.medium,
    onClick: () -> Unit,
) {
    if (type == ButtonType.TEXTONLY) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .clickable(enabled = enabled, onClick = onClick)
        ) {
            Text(
                text = text,
                color = if (enabled) type.textColor() else LocalColors.current.textDisabled,
                style = LocalTypography.current.labelLarge,
                textAlign = TextAlign.Center
            )
        }
    } else {
        Button(
            modifier = modifier
                .clip(shape)
                .height(height),
            colors = ButtonDefaults.buttonColors(backgroundColor = type.backgroundColor()),
            onClick = onClick,
            enabled = enabled,
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    color = if (enabled) type.textColor() else LocalColors.current.textDefault,
                    style = LocalTypography.current.labelLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun CustomButtonPreview() {
    CookTheme {
        Column(verticalArrangement = spacedBy(16.dp)) {
            Text("Primary Button")

            Column(verticalArrangement = spacedBy(8.dp)) {
                ActionButton(
                    text = "Click Me",
                    type = ButtonType.PRIMARY,
                    onClick = { /* Handle button click */ }
                )
                ActionButton(
                    text = "Click Me multiple times",
                    type = ButtonType.SECONDARY,
                    onClick = { /* Handle button click */ }
                )
                ActionButton(
                    text = "Click Me",
                    type = ButtonType.TERTIARY,
                    onClick = { /* Handle button click */ }
                )
                ActionButton(
                    text = "Click Me",
                    type = ButtonType.NEGATIVE,
                    onClick = { /* Handle button click */ }
                )
                ActionButton(
                    text = "Click Me",
                    type = ButtonType.TEXTONLY,
                    onClick = { /* Handle button click */ }
                )
            }
        }
    }
}

@Preview
@Composable
fun CustomButtonDisabledPreview() {
    CookTheme {
        Column(verticalArrangement = spacedBy(16.dp)) {
            Text("Primary Button")

            Column(verticalArrangement = spacedBy(8.dp)) {
                ActionButton(
                    text = "Click Me",
                    type = ButtonType.PRIMARY,
                    enabled = false,
                    onClick = { /* Handle button click */ }
                )
                ActionButton(
                    text = "Click Me multiple times",
                    type = ButtonType.SECONDARY,
                    enabled = false,
                    onClick = { /* Handle button click */ }
                )
                ActionButton(
                    text = "Click Me",
                    type = ButtonType.TERTIARY,
                    enabled = false,
                    onClick = { /* Handle button click */ }
                )
                ActionButton(
                    text = "Click Me",
                    type = ButtonType.NEGATIVE,
                    enabled = false,
                    onClick = { /* Handle button click */ }
                )
                ActionButton(
                    text = "Click Me",
                    type = ButtonType.TEXTONLY,
                    enabled = false,
                    onClick = { /* Handle button click */ }
                )
            }
        }
    }
}

