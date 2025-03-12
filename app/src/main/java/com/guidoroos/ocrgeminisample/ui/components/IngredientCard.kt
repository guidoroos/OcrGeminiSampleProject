package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.guidoroos.ocrgeminisample.model.UIIngredient
import com.guidoroos.ocrgeminisample.model.toFormattedString
import com.guidoroos.ocrgeminisample.ui.theme.CookTheme
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.ui.theme.LocalTypography
import com.guidoroos.ocrgeminisample.util.ListPosition
import com.guidoroos.ocrgeminisample.R


@Composable
fun IngredientCard(
    ingredient: UIIngredient,
    modifier: Modifier = Modifier,
    position: ListPosition = ListPosition.Only,
    background: Color = LocalColors.current.cardBackground,
) {
    ItemCard(
        item = ingredient,
        background = background,
        leading = {
            Icon(
                painter = painterResource(id = R.drawable.ic_drag_handle),
                contentDescription = null,
                tint = LocalColors.current.icon,
                modifier = Modifier.padding(start = LocalDimens.current.spacing2)
            )
        },
        main = { ingredientItem, mainModifier ->
            Text(
                text = ingredientItem.toFormattedString(LocalContext.current),
                style = LocalTypography.current.titleLarge,
                modifier = mainModifier
            )
        },
        trailing = {},
        position = position
    )
}

@Preview
@Composable
fun IngredientStepScreenPreviewOnly() {
    CookTheme {
        IngredientCard(
            ingredient = UIIngredient.mock(),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
