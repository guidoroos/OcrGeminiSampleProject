package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.ui.theme.LocalShapes
import com.guidoroos.ocrgeminisample.ui.theme.LocalTypography
import com.guidoroos.ocrgeminisample.ui.theme.CookTheme
import com.guidoroos.ocrgeminisample.R


@Composable
fun EmptyStateView(
    modifier: Modifier = Modifier,
    imageResource: Int,
    textResource: Int,
) {

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            colors = CardDefaults.cardColors(
                containerColor = LocalColors.current.emptyStateBackground,
                contentColor = LocalColors.current.cardContent
            ),
            modifier = modifier
                .fillMaxSize()
                .padding(LocalDimens.current.spacing4)
        ) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier.fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .clip(LocalShapes.current.small)
                        .padding(horizontal = LocalDimens.current.spacing4)
                        .padding(vertical = LocalDimens.current.spacing4)

                ) {
                    Image(
                        painter = painterResource(id = imageResource),
                        contentDescription = "Empty List",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(50.dp)
                            .alpha(0.7f)
                    )

                    Text(
                        text = stringResource(id = textResource),
                        modifier = Modifier
                            .padding(LocalDimens.current.spacing4),
                        style = LocalTypography.current.bodyLarge,
                        color = LocalColors.current.textDefault,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EmptyStateViewPreview() {
    CookTheme {
            EmptyStateView(
                imageResource = R.drawable.ic_meal,
                textResource = R.string.steps_empty_state,

            )
    }
}