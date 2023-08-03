package com.franciscogarciagarzon.learningpath.ui.screens.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomLinearProgressIndicator(progress: Float) {
    LinearProgressIndicator(
        progress = progress,
        color = Color.Red,
        modifier = Modifier
            .height(15.dp)
            .clip(RoundedCornerShape(16.dp)),
        trackColor = Color.White
    )
}

@Composable
fun StatIndicator(statValue: Int) {
    LinearProgressIndicator(
        progress = statValue / 255f,
        color = Color.Red,
        modifier = Modifier
            .height(35.dp)
            .padding(top = 5.dp, bottom = 5.dp)
            .clip(RoundedCornerShape(16.dp)),
        trackColor = Color.White
    )
}

@Composable
@Preview
fun CLPIPreview() {
    CustomLinearProgressIndicator(0.7f)
}