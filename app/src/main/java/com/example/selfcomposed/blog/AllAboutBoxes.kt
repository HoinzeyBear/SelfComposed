package com.example.selfcomposed.blog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AllAboutBoxes() {
    Surface() {

    }
}

@Composable
fun SingularBox() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Green)) {

    }
}

@Composable
fun StackedBoxes() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Green)) {

        Box(modifier = Modifier
            .size(150.dp, 150.dp)
            .background(color = Color.Red)
            .align(Alignment.Center)) {

        }
    }
}

@Composable
fun StackedBoxesOpacity() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Green)) {

        Text(modifier = Modifier.align(Alignment.Center),
            text = "You can see me through the red box")

        Box(modifier = Modifier
            .fillMaxSize()
            .alpha(0.6F)
            .background(color = Color.Red)
            .align(Alignment.Center)) {

        }
    }
}

@Composable
fun StackedBoxesOpacityWithFab() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Green)) {

        Text(modifier = Modifier.align(Alignment.Center),
            text = "You can see me through the red box")

        Box(modifier = Modifier
            .fillMaxSize()
//            .size(200.dp,200.dp)
            .alpha(0.6F)
            .background(color = Color.Red)
            .align(Alignment.Center)) {

        }

        FloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd).padding(15.dp),
            onClick = { },
            backgroundColor = Color.DarkGray,) {

            Text(modifier = Modifier.align(Alignment.Center),
                text = "BTN", color = Color.White)
        }
    }
}

@Preview
@Composable
fun PreviewSingularBox() {
    Surface(modifier = Modifier.fillMaxSize()) {
        SingularBox()
    }
}

@Preview
@Composable
fun PreviewStackedBoxes() {
    Surface(modifier = Modifier.fillMaxSize()) {
        StackedBoxes()
    }
}

@Preview
@Composable
fun PreviewStackedBoxesOpacity() {
    Surface(modifier = Modifier.fillMaxSize()) {
        StackedBoxesOpacity()
    }
}

@Preview
@Composable
fun PreviewStackedBoxesOpacityWithFab() {
    Surface(modifier = Modifier.fillMaxSize()) {
        StackedBoxesOpacityWithFab()
    }
}