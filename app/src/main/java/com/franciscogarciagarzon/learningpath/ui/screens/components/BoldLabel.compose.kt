package com.franciscogarciagarzon.learningpath.ui.screens.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoldLabel(text: String, modifier: Modifier = Modifier, textAlignment: TextAlign = TextAlign.Start) {
    Text(
        modifier = modifier
            .padding(5.dp, end = 5.dp),
        text = text.capitalize(locale = Locale.current),
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlignment
    )
}

@Composable
fun BoldLabel40(text: String, modifier: Modifier = Modifier, textAlignment: TextAlign) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp),
        text = text.capitalize(locale = Locale.current),
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlignment
    )
}

@Composable
fun BoldLabel30(text: String, modifier: Modifier = Modifier, textAlignment: TextAlign) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp),
        text = text.capitalize(locale = Locale.current),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = textAlignment
    )
}

