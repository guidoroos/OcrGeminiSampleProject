package com.guidoroos.ocrgeminisample.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Shape(
    val extraSmall: RoundedCornerShape = RoundedCornerShape(4.dp),
    val small: RoundedCornerShape = RoundedCornerShape(8.dp),
    val medium: RoundedCornerShape = RoundedCornerShape(12.dp),
    val large: RoundedCornerShape = RoundedCornerShape(16.dp),
    val extraLarge: RoundedCornerShape = RoundedCornerShape(24.dp),
    val topOnlyMedium: RoundedCornerShape = RoundedCornerShape(
        topStart = 12.dp,
        topEnd = 12.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    ),
    val bottomOnlyMedium: RoundedCornerShape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 12.dp,
        bottomEnd = 12.dp
    )
)

@Composable
fun ButtonWithShape(shape: CornerBasedShape) {
    Button(
        onClick = {},
        shape = shape,
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Button (Small)")
    }
}

@Composable
fun CardWithShape(shape: CornerBasedShape) {
    Card(
        shape = shape,
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Card (Medium)")
    }
}

@Composable
fun SheetWithShape(shape: CornerBasedShape) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Show BottomSheet")
        }
    }
}

@Preview
@Composable
fun ButtonPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ButtonWithShape(RoundedCornerShape(12.dp))
    }
}

@Preview
@Composable
fun CardPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        CardWithShape(RoundedCornerShape(12.dp))
    }
}

@Preview
@Composable
fun SheetPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        SheetWithShape(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
    }
}
