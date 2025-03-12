package com.guidoroos.ocrgeminisample.ui.components

import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guidoroos.ocrgeminisample.R
import com.guidoroos.ocrgeminisample.model.UIStep
import com.guidoroos.ocrgeminisample.ui.theme.CookTheme
import com.guidoroos.ocrgeminisample.ui.theme.LocalColors
import com.guidoroos.ocrgeminisample.ui.theme.LocalDimens
import com.guidoroos.ocrgeminisample.ui.theme.LocalTypography
import com.guidoroos.ocrgeminisample.util.ListPosition
import com.guidoroos.ocrgeminisample.util.formatSeconds

@Composable
fun StepCard(
    step: UIStep,
    modifier: Modifier = Modifier,
    position: ListPosition = ListPosition.Only,
) {
    ItemCard(
        item = step,
        leading = {
            Icon(
                painter = painterResource(id = R.drawable.ic_drag_handle),
                contentDescription = "meal Icon",
                tint = LocalColors.current.icon,
                modifier = Modifier.padding(start = LocalDimens.current.spacing2)
            )
        },
        main = { stepItem, mainModifier ->
            val context = LocalContext.current

            Column(modifier = mainModifier) {
                Text(
                    text = stepItem.description,
                    style = LocalTypography.current.titleLarge,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )

                if (stepItem.timeSeconds != null) {
                    Spacer(modifier = Modifier.height(LocalDimens.current.spacing2))

                    Row(
                        horizontalArrangement = spacedBy(LocalDimens.current.spacing1),
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_timer),
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )

                        Text(
                            text = context.formatSeconds(stepItem.timeSeconds),
                            style = LocalTypography.current.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        },
        trailing = {},
        position = position
    )
}

@Preview
@Composable
fun StepStepScreenPreviewOnly() {
    CookTheme {
        StepCard(
            step = UIStep.mocks().last(),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

