@file:OptIn(ExperimentalTextApi::class)

package com.example.selfcomposed.workshop

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

/*
    https://medium.com/androiddevelopers/brushing-up-on-compose-text-coloring-84d7d70dd8fa
    https://medium.com/androiddevelopers/animating-brush-text-coloring-in-compose-%EF%B8%8F-26ae99d9b402
 */

private val gradientColors = listOf(
    Cyan,
    androidx.compose.ui.graphics.Color.Companion.Blue,
    androidx.compose.ui.graphics.Color.Companion.Green)

@SuppressLint("NotConstructor")
@Composable
fun TextColoring() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.fillMaxSize(),
            text = "This is the text I needed to be displayed in this example",
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            ),
            fontSize = 30.sp
        )
    }
}
