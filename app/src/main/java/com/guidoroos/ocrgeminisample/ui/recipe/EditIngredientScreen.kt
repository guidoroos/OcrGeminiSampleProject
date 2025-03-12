package com.guidoroos.ocrgeminisample.ui.recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.guidoroos.ocrgeminisample.R
import com.guidoroos.ocrgeminisample.model.UIIngredient
import com.guidoroos.ocrgeminisample.ui.components.EmptyStateView
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.ui.theme.CookTheme
import com.guidoroos.ocrgeminisample.ui.components.IngredientList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditIngredientScreen(
    navController: NavController,
    viewModel: RecipeViewModel
) {

    val ingredientState = viewModel.ingredientsState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.defaultBackground)
            .padding(top = LocalDimens.current.spacing2)
            .padding(LocalDimens.current.spacing3),
        verticalArrangement = Arrangement.spacedBy(LocalDimens.current.spacing2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.ingredients),
            style = MaterialTheme.typography.headlineMedium
        )

        if (ingredientState.value.isEmpty()) {
            EmptyStateView(
                imageResource = R.drawable.ic_meal,
                textResource = R.string.ingredients_empty_state,
            )
        } else {
            IngredientOverviewContent(
                ingredients = ingredientState.value
            )

        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun IngredientOverviewContent(
    ingredients: List<UIIngredient>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.defaultBackground)
            .padding(LocalDimens.current.spacing3),
        verticalArrangement = Arrangement.spacedBy(LocalDimens.current.spacing2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IngredientList(
            ingredients = ingredients,
            modifier = Modifier
                .weight(1f)
                .background(LocalColors.current.defaultBackground),
        )
    }

}

@Preview
@Composable
fun EditIngredientScreenPreview() {
    CookTheme {
        IngredientOverviewContent(
            ingredients = UIIngredient.mocks(),
        )
    }
}

