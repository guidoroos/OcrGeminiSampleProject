package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.guidoroos.ocrgeminisample.R
import com.guidoroos.ocrgeminisample.ui.theme.CookTheme
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.ui.theme.LocalTypography

@Composable
fun LoadingDialog(
    isLoading: Boolean,
    content: String,
) {
    if (isLoading) {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {},
            containerColor = LocalColors.current.defaultBackground,
            text = {
                Column(
                    verticalArrangement = spacedBy(LocalDimens.current.spacing4),
                ) {
                    Text(
                        text = stringResource(R.string.loading),
                        style = LocalTypography.current.labelLarge,
                        modifier = Modifier.padding(start = LocalDimens.current.spacing4)
                    )

                    Row(
                        horizontalArrangement = spacedBy(LocalDimens.current.spacing3),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(30.dp),
                            color = LocalColors.current.loadingIndicator
                        )
                        Text(
                            text = content,
                            style = LocalTypography.current.bodyMedium,
                        )
                    }
                }
            },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        )
    }
}

@Composable
@Preview
fun LoadingDialogPreview() {
    CookTheme {
        LoadingDialog(
            isLoading = true,
            content = "Loading content, this might take up to 15 seconds"
        )
    }
}