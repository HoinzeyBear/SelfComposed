@file:OptIn(ExperimentalTextApi::class)

package com.example.selfcomposed.workshop

import android.annotation.SuppressLint
import android.graphics.BitmapShader
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import com.example.selfcomposed.R

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


//        Text(
//            modifier = Modifier.fillMaxSize(),
//            text = "This is the text I needed to be displayed in this example " +
//                    "but I want to make it take up a couple of more lines." +
//                    "Oh Spaghetti monster where arth thou",
//            style = TextStyle(
//
//
////                brush = ScaledThirdBrush(Brush.linearGradient(
////                    colors = gradientColors,
////                    tileMode = TileMode.Repeated
////                ) as ShaderBrush)
//
////                brush = Brush.linearGradient(
////                    colors = gradientColors
////                )
//            ),
//            fontSize = 30.sp
//        )
    }
}
