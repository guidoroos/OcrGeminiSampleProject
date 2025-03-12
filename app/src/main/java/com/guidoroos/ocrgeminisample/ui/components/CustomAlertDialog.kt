package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.guidoroos.ocrgeminisample.ui.theme.CookTheme
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.ui.theme.LocalTypography

enum class AlertType { Info, Warning, Error }


@Composable
fun CustomAlertDialog(
    alertType: AlertType,
    title: String,
    message: String,
    positiveButtonText: String,
    onPositiveButtonClick: () -> Unit,
    negativeButtonText: String? = null,
    onNegativeButtonClick: (() -> Unit)? = null,
    dismissable: Boolean = true
) {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        AlertDialog(
            properties = DialogProperties(
                dismissOnBackPress = dismissable,
                dismissOnClickOutside = dismissable,
            ),
            modifier = Modifier.fillMaxWidth(),
            onDismissRequest = { showDialog = false },
            title = {
                Text(
                    text = title,
                    style = LocalTypography.current.headlineSmall,
                    color = when (alertType) {
                        AlertType.Info -> LocalColors.current.alertTitleInfo
                        AlertType.Warning -> LocalColors.current.alertTitleWarning
                        AlertType.Error -> LocalColors.current.alertTitleError
                    }
                )
            },
            text = {
                Text(
                    text = message,
                    style = LocalTypography.current.bodyLarge,
                    color = LocalColors.current.alertMessage
                )
            },
            buttons = {
                Row(
                    horizontalArrangement = spacedBy(LocalDimens.current.spacing1),
                    modifier = Modifier.padding(horizontal = LocalDimens.current.spacing2)
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(backgroundColor = LocalColors.current.primaryButtonColor),
                        modifier = Modifier.weight(1f),
                        onClick = {
                            onPositiveButtonClick()
                            showDialog = false
                        }
                    ) {
                        Text(
                            text = positiveButtonText,
                            style = LocalTypography.current.bodyLarge,
                            color = LocalColors.current.primaryButtonTextColor
                        )
                    }
                    negativeButtonText?.let {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .weight(1f)
                                .clickable {
                                    onNegativeButtonClick?.invoke()
                                    showDialog = false
                                }
                        ) {
                            Text(
                                text = it,
                                style = LocalTypography.current.bodyLarge,
                                color = LocalColors.current.textDefault,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(LocalDimens.current.spacing3)
                            )
                        }

                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun CustomAlertDialogPreviewOneButtonInfo() {
    CookTheme {
        CustomAlertDialog(
            title = "Alert Title",
            message = "This is a sample message for the alert dialog.",
            positiveButtonText = "OK",
            onPositiveButtonClick = { },
            alertType = AlertType.Info
        )
    }
}

@Preview
@Composable
fun CustomAlertDialogPreviewOneButtonError() {
    CookTheme {
        CustomAlertDialog(
            title = "Alert Title",
            message = "This is a sample message for the alert dialog.",
            positiveButtonText = "OK",
            onPositiveButtonClick = { },
            alertType = AlertType.Error
        )
    }
}

@Preview
@Composable
fun CustomAlertDialogPreviewTwoButtonWarning() {
    CookTheme {
        CustomAlertDialog(
            title = "Alert Title",
            message = "This is a sample message for the alert dialog.",
            positiveButtonText = "OK",
            onPositiveButtonClick = { },
            negativeButtonText = "Cancel",
            alertType = AlertType.Warning
        )
    }
}

