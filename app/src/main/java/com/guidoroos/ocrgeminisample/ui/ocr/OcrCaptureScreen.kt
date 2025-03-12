package com.guidoroos.ocrgeminisample.ui.screen.ocr

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.guidoroos.ocrgeminisample.ui.components.AppScaffold
import com.guidoroos.ocrgeminisample.ui.view.base.BackArrow
import com.guidoroos.ocrgeminisample.ui.NavigationPage
import com.guidoroos.ocrgeminisample.ui.components.AlertType
import com.guidoroos.ocrgeminisample.ui.components.CustomAlertDialog
import com.guidoroos.ocrgeminisample.ui.components.LoadingDialog
import com.guidoroos.ocrgeminisample.ui.components.LoadingIndicator
import com.guidoroos.ocrgeminisample.ui.ocr.CameraPreviewScreen
import com.guidoroos.ocrgeminisample.ui.recipe.RecipeViewModel
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.util.ResultOf
import com.guidoroos.ocrgeminisample.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OcrCaptureScreen(
    navController: NavController,
    viewModel: RecipeViewModel = viewModel()
) {
    val textState = viewModel.imageTextState.collectAsStateWithLifecycle()
    val saveState = viewModel.saveRecipeState.collectAsStateWithLifecycle()

    val showPermissionPopup = remember { mutableStateOf(false) }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            // Camera permission granted
        } else {
            showPermissionPopup.value = true
        }
    }

    LaunchedEffect(saveState.value) {
        if (saveState.value is ResultOf.Success) {
            viewModel.resetSaveState()

            navController.navigate(NavigationPage.Recipe.route)
        }
    }

    AppScaffold(
        topAppBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = LocalColors.current.appBarBackground,
                    titleContentColor = LocalColors.current.appBarText,
                ),
                navigationIcon = {
                    BackArrow(navController = navController)
                },
                title = {},
                actions = {
                    if (viewModel.extractedText.isNotEmpty() && saveState.value !is ResultOf.Loading && textState.value !is ResultOf.Loading) {
                        IconButton(
                            onClick = {
                                viewModel.deleteLastOcrText()
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_delete),
                                contentDescription = null,
                                tint = LocalColors.current.appBarIcon,
                                modifier = Modifier.padding(start = LocalDimens.current.spacing2)
                            )
                        }
                    }
                }
            )
        },
        content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {

                if (ContextCompat.checkSelfPermission(
                        LocalContext.current,
                        Manifest.permission.CAMERA
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    // Camera permission already granted
                    // Implement camera related code
                } else {
                    LaunchedEffect(Unit) {
                        cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                }


                Box {
                    CameraPreviewScreen(
                        isLoading = textState.value is ResultOf.Loading || saveState.value is ResultOf.Loading
                    ) { image ->
                        viewModel.extractTextFromImage(image)
                    }

                    if (textState.value is ResultOf.Loading) {
                        LoadingIndicator()
                    } else if (saveState.value is ResultOf.Loading) {
                        LoadingDialog(
                            isLoading = true,
                            content = stringResource(R.string.loading_message_gemini)
                        )
                    }
                }


                if (showPermissionPopup.value) {
                    CustomAlertDialog(
                        alertType = AlertType.Error,
                        title = stringResource(R.string.camera_denied_title),
                        message = stringResource(R.string.camera_denied_message),
                        positiveButtonText = stringResource(id = R.string.ok),
                        onPositiveButtonClick = {
                            showPermissionPopup.value = false
                        },
                        dismissable = false
                    )
                }

                if (saveState.value is ResultOf.Error) {
                    CustomAlertDialog(
                        alertType = AlertType.Error,
                        title = stringResource(R.string.error_title),
                        message = stringResource(id = (saveState.value as ResultOf.Error).errorResourceId),
                        positiveButtonText = stringResource(id = R.string.ok),
                        onPositiveButtonClick = {
                            viewModel.resetSaveState()
                        }
                    )
                }

                when (val result = textState.value) {
                    is ResultOf.Error -> {
                        val defaultError = stringResource(id = result.errorResourceId)
                        val customError = result.customErrorMessage
                        val errorMessage = if (customError != null) {
                            "$defaultError\n$customError"
                        } else {
                            defaultError
                        }

                        CustomAlertDialog(
                            alertType = AlertType.Error,
                            title = stringResource(R.string.error_title),
                            message = errorMessage,
                            positiveButtonText = stringResource(id = R.string.ok),
                            onPositiveButtonClick = {
                                viewModel.resetImageTextState()
                            }
                        )
                    }

                    is ResultOf.Success -> {
                        CustomAlertDialog(
                            alertType = AlertType.Info,
                            title = stringResource(R.string.ocr_confirmation_title),
                            message = stringResource(R.string.ocr_confirmation_message),
                            positiveButtonText = stringResource(id = R.string.ocr_process_output),
                            onPositiveButtonClick = {
                                viewModel.resetImageTextState()
                                viewModel.processOcrTextAndSaveRecipe()
                            },
                            negativeButtonText = stringResource(id = R.string.ocr_capture_more_text),
                            onNegativeButtonClick = {
                                viewModel.resetImageTextState()
                            }
                        )
                    }

                    else -> {
                        // Do nothing
                    }

                }

            }
        }
    )
}
