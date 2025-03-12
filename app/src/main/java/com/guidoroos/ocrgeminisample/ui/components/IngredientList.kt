package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guidoroos.ocrgeminisample.model.UIIngredient
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.util.ListPosition

@Composable
fun IngredientList(
    ingredients: List<UIIngredient>,
    modifier: Modifier = Modifier,

    ) {
    val stateList = rememberLazyListState()


    LazyColumn(
        modifier = modifier
            .fillMaxWidth(),
        state = stateList,
        contentPadding = PaddingValues(LocalDimens.current.spacing1),
        verticalArrangement = spacedBy(0.dp)
    ) {

        itemsIndexed(
            items = ingredients,
        ) { index, item ->
            val listPosition = ListPosition.from(
                index = index,
                size = ingredients.size
            )

            Column(modifier = modifier.padding(horizontal = LocalDimens.current.spacing1)) {
                IngredientCard(
                    ingredient = item,
                    position = listPosition
                )

                if (listPosition == ListPosition.First || listPosition == ListPosition.Middle) {
                    HorizontalDivider(color = LocalColors.current.divider)
                }
            }
        }
    }
}



@Composable
@Preview
fun IngredientListPreview() {
    IngredientList(
        ingredients = UIIngredient.mocks(),
    )

}
