package com.example.selfcomposed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.selfcomposed.ui.theme.BlogGreen
import com.example.selfcomposed.ui.theme.BlueContrast
import com.example.selfcomposed.ui.theme.OrangeHighlight
import com.example.selfcomposed.ui.theme.PurplyBlueContrast

@Composable
fun AllAboutRows() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp)) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Horizontal Start")
@Composable
fun HorizontalStart() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            horizontalArrangement = Arrangement.Start) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Horizontal center")
@Composable
fun HorizontalCenter() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            horizontalArrangement = Arrangement.Center) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Horizontal End")
@Composable
fun HorizontalEnd() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            horizontalArrangement = Arrangement.End) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Horizontal Space Between")
@Composable
fun HorizontalSpaceBetween() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Horizontal Space Evenly")
@Composable
fun HorizontalSpaceEvenly() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Horizontal Space Around")
@Composable
fun HorizontalSpaceAround() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            horizontalArrangement = Arrangement.SpaceAround) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical Top")
@Composable
fun VerticalTop() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalAlignment = Alignment.Top) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical Bottom")
@Composable
fun VerticalBottom() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalAlignment = Alignment.Bottom) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical Center vertically")
@Composable
fun VerticalCenterVertically() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalAlignment = Alignment.CenterVertically) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Align")
@Composable
fun Align() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp)) {
            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp).align(Alignment.CenterVertically), color = BlogGreen)
            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Weight even dist")
@Composable
fun WeightEvenDist() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp)) {
            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp).weight(1.0f), color = BlogGreen)
            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp).weight(1.0f), color = BlogGreen)
            Text(text = "Text 3", modifier = Modifier.background(BlueContrast).padding(20.dp).weight(1.0f), color = BlogGreen)
        }
    }
}

@Preview(name = "Weight odd dist")
@Composable
fun WeightOddDist() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.background(Color.LightGray).padding(5.dp)) {
            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp).weight(1f), color = BlogGreen)
            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp).weight(2f), color = BlogGreen)
            Text(text = "Text 3", modifier = Modifier.background(BlueContrast).padding(20.dp).weight(1f), color = BlogGreen)
        }
    }
}