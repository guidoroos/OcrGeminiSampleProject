package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors


@Composable
fun AppScaffold(
    topAppBar: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {

    Scaffold(
        topBar = topAppBar,
        containerColor = LocalColors.current.defaultBackground,
        floatingActionButton = floatingActionButton
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            content()
        }
    }
}


