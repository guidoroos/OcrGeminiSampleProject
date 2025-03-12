package com.guidoroos.ocrgeminisample.ui.view.base

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun BackArrow(navController: NavController) {
    val isPreview = LocalInspectionMode.current

    if (navController.previousBackStackEntry != null || isPreview) {
        Box(
            modifier = Modifier
                .clickable {
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(100)
                        navController.navigateUp()
                    }
                }
                .size(50.dp)
                .padding(LocalDimens.current.spacing2)
                .padding(start = LocalDimens.current.spacing3)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Localized description",
                tint = LocalColors.current.appBarText,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}