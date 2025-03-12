package com.guidoroos.ocrgeminisample.ui.recipe

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.guidoroos.ocrgeminisample.ui.components.AppScaffold
import com.guidoroos.ocrgeminisample.ui.components.DefaultTopBar
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.ui.theme.LocalTypography
import com.guidoroos.ocrgeminisample.R
import kotlinx.coroutines.launch

@Composable
fun RecipeBaseScreen(
    navController: NavController,
    recipeViewModel: RecipeViewModel = viewModel()
) {
    AppScaffold(
        content = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                RecipeBaseScreenContent(
                    navController = navController,
                    recipeViewModel = recipeViewModel,
                )
            }
        },
        topAppBar = {
            DefaultTopBar(
                navController = navController
            )
        }
    )
}

@Composable
fun RecipeBaseScreenContent(
    navController: NavController,
    recipeViewModel: RecipeViewModel,
) {
    val initialTabIndex = 0
    var selectedTabIndex by remember { mutableIntStateOf(initialTabIndex) }
    val tabItems = remember { TabItem.entries.toTypedArray() }
    val pagerState = rememberPagerState(initialPage = selectedTabIndex) { tabItems.size }

    val recipeState by recipeViewModel.recipeState.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = LocalColors.current.appBarBackground,
            contentColor = LocalColors.current.appBarIconVariant,
            indicator = @Composable { tabPositions ->
                if (selectedTabIndex < tabPositions.size) {
                    SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = LocalColors.current.appBarIconVariant,
                    )
                }
            }
        ) {
            // tab items
            tabItems.forEachIndexed { index, item ->
                val isSelected = index == selectedTabIndex

                Text(
                    text = stringResource(id = item.titleResource),
                    style = LocalTypography.current.titleMedium,
                    textAlign = TextAlign.Center,
                    color = if (isSelected) {
                        LocalColors.current.appBarTextSelected
                    } else {
                        LocalColors.current.appBarText
                    },
                    modifier = Modifier
                        .clickable {
                            selectedTabIndex = index
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                        .padding(all = LocalDimens.current.spacing3)
                )
            }
        }


        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) {
            when (selectedTabIndex) {
                0 -> RecipeOverviewScreen(
                    navController = navController,
                    viewModel = recipeViewModel
                )

                1 -> EditIngredientScreen(
                    navController = navController,
                    viewModel = recipeViewModel
                )

                2 -> EditStepScreen(
                    navController = navController,
                    viewModel = recipeViewModel
                )
            }
        }

        // change the tab item when current page is changed
        LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
            if (!pagerState.isScrollInProgress) {
                selectedTabIndex = pagerState.currentPage
            }
        }
    }
}

enum class TabItem(val titleResource: Int) {
    Overview(titleResource = R.string.overview),
    Ingredients(titleResource = R.string.ingredients_short),
    Steps(titleResource = R.string.steps)
}

