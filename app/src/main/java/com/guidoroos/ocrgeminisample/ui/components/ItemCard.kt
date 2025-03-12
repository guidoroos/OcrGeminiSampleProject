package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.util.ListPosition
import com.guidoroos.ocrgeminisample.util.ListPosition.Companion.shape

@Composable
fun <T> ItemCard(
    item: T,
    modifier: Modifier = Modifier,
    leading: (@Composable (T) -> Unit)? = null,
    main: @Composable (T, Modifier) -> Unit,
    trailing: @Composable (T) -> Unit,
    position: ListPosition = ListPosition.Only,
    background: Color = LocalColors.current.cardBackground
) {
    val shape = position.shape()

    Card(
        shape = shape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = background,
            contentColor = LocalColors.current.cardContent
        ),
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalDimens.current.spacing2),
            horizontalArrangement = spacedBy(LocalDimens.current.spacing4),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leading != null) {
                leading(item)
            }
            main(item, Modifier.weight(1f))
            trailing(item)
        }
    }
}


