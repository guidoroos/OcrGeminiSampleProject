package com.guidoroos.ocrgeminisample.ui.recipe

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.guidoroos.ocrgeminisample.ui.components.EmptyStateView
import com.guidoroos.ocrgeminisample.ui.components.RecipeTextField
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.ui.theme.LocalShapes
import com.guidoroos.ocrgeminisample.ui.theme.LocalTypography
import com.guidoroos.ocrgeminisample.R

@Composable
fun RecipeOverviewScreen(
    navController: NavController,
    viewModel: RecipeViewModel,
) {
    val recipeState = viewModel.recipeState.collectAsStateWithLifecycle()
    val recipe = recipeState.value

    if (recipe == null) {
        EmptyStateView(
            imageResource = R.drawable.ic_error,
            textResource = R.string.no_recipe_found
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LocalColors.current.secondaryBackground)
                .padding(LocalDimens.current.spacing3),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = spacedBy(LocalDimens.current.spacing2)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = spacedBy(LocalDimens.current.spacing3)
            ) {

                Image(
                    painter = painterResource(R.drawable.ic_meal), contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(LocalShapes.current.extraSmall)
                        .border(
                            border = BorderStroke(1.dp, Color.Black.copy(alpha = 0.2f)),
                            shape = LocalShapes.current.extraSmall
                        ),

                    )

                val backgroundColor = LocalColors.current.textFieldBackground
                val textColor = LocalColors.current.textFieldText
                val borderColor = LocalColors.current.textFieldBorder

                Row(
                    horizontalArrangement = spacedBy(LocalDimens.current.spacing2),
                    modifier = Modifier
                        .padding(horizontal = LocalDimens.current.spacing1)
                        .fillMaxWidth()
                ) {
                    RecipeTextField(
                        text = recipeState.value?.name ?: "",
                        textStyle = LocalTypography.current.headlineSmall,
                        onClick = {},
                        backgroundColor = backgroundColor,
                        borderColor = borderColor,
                        textColor = textColor,
                        modifier = Modifier.weight(4f)
                    )

                    RecipeTextField(
                        text = recipeState.value?.servings.toString(),
                        textStyle = LocalTypography.current.bodyLarge,
                        onClick = { },
                        icon = {
                            Icon(
                                painterResource(R.drawable.ic_people),
                                contentDescription = null,
                                tint = textColor
                            )
                        },
                        backgroundColor = backgroundColor,
                        borderColor = borderColor,
                        textColor = textColor,
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(
                    horizontalArrangement = spacedBy(LocalDimens.current.spacing2),
                    modifier = Modifier.padding(horizontal = LocalDimens.current.spacing1)
                ) {
                    RecipeTextField(
                        text = pluralStringResource(
                            R.plurals.minutes, recipe.preparationMinutes, recipe.preparationMinutes
                        ),
                        textStyle = LocalTypography.current.bodyLarge,
                        onClick = { },
                        backgroundColor = backgroundColor,
                        borderColor = borderColor,
                        textColor = textColor,
                        icon = {
                            Icon(
                                painterResource(R.drawable.ic_timer),
                                contentDescription = null,
                                tint = textColor
                            )
                        },
                        modifier = Modifier
                            .weight(1f)

                    )
                    RecipeTextField(
                        text = recipe.cuisine,
                        textStyle = LocalTypography.current.bodyLarge,
                        onClick = { },
                        backgroundColor = backgroundColor,
                        borderColor = borderColor,
                        textColor = textColor,
                        icon = {
                            Icon(
                                painterResource(R.drawable.ic_pin_drop),
                                contentDescription = null,
                                tint = textColor
                            )
                        },
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)

                    )
                }

                RecipeTextField(
                    text = recipe.description,
                    textStyle = LocalTypography.current.bodyLarge,
                    onClick = { },
                    backgroundColor = backgroundColor,
                    borderColor = borderColor,
                    shape = LocalShapes.current.medium,
                    lines = 4,
                    textColor = textColor,
                    modifier = Modifier.padding(horizontal = LocalDimens.current.spacing1)
                )
            }
        }
    }
}

