package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import com.guidoroos.ocrgeminisample.ui.view.base.BackArrow
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    navController: NavController,
    title: String? = null,
    actions: @Composable RowScope. () -> Unit = {}
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = LocalColors.current.appBarBackground,
            titleContentColor = LocalColors.current.appBarText,
        ),
        title = {
            if (title != null) {
                Text(
                    text = title,
                    style = LocalTypography.current.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = LocalColors.current.invertedTextFieldText,
                )
            }
        },
        navigationIcon = {
                BackArrow(navController)
        },
        actions = actions
    )
}