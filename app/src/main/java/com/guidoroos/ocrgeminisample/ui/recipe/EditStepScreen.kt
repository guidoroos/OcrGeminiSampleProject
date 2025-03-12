package com.guidoroos.ocrgeminisample.ui.recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.guidoroos.ocrgeminisample.R
import com.guidoroos.ocrgeminisample.model.UIStep
import com.guidoroos.ocrgeminisample.ui.components.EmptyStateView
import com.guidoroos.ocrgeminisample.ui.components.StepCard
import com.guidoroos.ocrgeminisample.ui.theme.CookTheme
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.util.ListPosition

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditStepScreen(
    navController: NavController,
    viewModel: RecipeViewModel
) {
    val stepState = viewModel.stepsState.collectAsStateWithLifecycle()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.defaultBackground)
            .padding(top = LocalDimens.current.spacing2)
            .padding(LocalDimens.current.spacing3),
        verticalArrangement = spacedBy(LocalDimens.current.spacing2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.steps),
            style = MaterialTheme.typography.headlineMedium
        )

        if (stepState.value.isEmpty()) {
            EmptyStateView(
                imageResource = R.drawable.ic_meal,
                textResource = R.string.steps_empty_state,
            )
        } else {
            StepOverviewContent(
                steps = stepState.value
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun StepOverviewContent(
    steps: List<UIStep>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LocalColors.current.defaultBackground)
            .padding(LocalDimens.current.spacing3),
        verticalArrangement = spacedBy(LocalDimens.current.spacing2),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StepList(
            steps = steps,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun StepList(
    steps: List<UIStep>,
    modifier: Modifier = Modifier
) {

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .background(LocalColors.current.defaultBackground),
        state = rememberLazyListState(),
        contentPadding = PaddingValues(LocalDimens.current.spacing1),
        verticalArrangement = spacedBy(0.dp)
    ) {

        itemsIndexed(
            items = steps,
        ) { index, item ->

            val listPosition = ListPosition.from(
                index = index,
                size = steps.size
            )

            Column(modifier = modifier.padding(horizontal = LocalDimens.current.spacing1)) {
                StepCard(
                    step = item,
                    position = listPosition
                )

                if (listPosition == ListPosition.First || listPosition == ListPosition.Middle) {
                    HorizontalDivider(color = LocalColors.current.divider)
                }
            }
        }
    }

}

@Preview
@Composable
fun StepOverviewContentPreview() {
    CookTheme {
        StepOverviewContent(
            steps = UIStep.mocks(),
        )
    }
}

