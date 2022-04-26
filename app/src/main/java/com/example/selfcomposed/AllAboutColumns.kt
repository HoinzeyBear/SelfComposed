package com.example.selfcomposed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.selfcomposed.ui.theme.*

@Composable
fun AllAboutColumns() {
    Surface(
//        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalArrangement = Arrangement.Bottom) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical top")
@Composable
fun vertical_top() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalArrangement = Arrangement.Top) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical center")
@Composable
fun vertical_center() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalArrangement = Arrangement.Center) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical bottom")
@Composable
fun vertical_bottom() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalArrangement = Arrangement.Bottom) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical space between")
@Composable
fun vertical_space_between() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalArrangement = Arrangement.SpaceBetween) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical space around")
@Composable
fun vertical_space_around() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalArrangement = Arrangement.SpaceAround) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical space evenly")
@Composable
fun vertical_space_evenly() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalArrangement = Arrangement.SpaceEvenly) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Horizontal start")
@Composable
fun horizontal_start() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
        horizontalAlignment = Alignment.Start) {
            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)
            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Horizontal center")
@Composable
fun horizontal_center() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)
            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Horizontal end")
@Composable
fun horizontal_end() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            horizontalAlignment = Alignment.End) {
            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp), color = BlogGreen)
            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Vertical space evenly horizontal align")
@Composable
fun vertical_space_evenly_horizontal_align() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp),
            verticalArrangement = Arrangement.SpaceEvenly) {

            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp).align(Alignment.CenterHorizontally), color = BlogGreen)

            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Weight 2 vs 1")
@Composable
fun weight_2_vs_1() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp)) {
            Text(text = "Text 1", modifier = Modifier.background(OrangeHighlight).padding(20.dp).weight(2f), color = BlogGreen)
            Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp).weight(1f), color = BlogGreen)
        }
    }
}

@Preview(name = "Weight 3 views ")
@Composable
fun weight_3_views() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp)) {
            Text(text = "Text 1", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp).weight(2f), color = BlogGreen)
            Text(text = "Text 2", modifier = Modifier.background(OrangeHighlight).padding(20.dp).weight(1f), color = BlogGreen)
            Text(text = "Text 3", modifier = Modifier.background(BlueContrast).padding(20.dp).weight(1f), color = BlogGreen)
        }
    }
}

@Preview(name = "Weight 3 views now fill")
@Composable
fun weight_3_views_no_fill() {
    Surface( modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.background(Color.LightGray).padding(5.dp)) {
            Text(text = "Text 1", modifier = Modifier.background(PurplyBlueContrast).padding(20.dp).weight(2f,fill = false), color = BlogGreen)
            Text(text = "Text 2", modifier = Modifier.background(OrangeHighlight).padding(20.dp).weight(1f), color = BlogGreen)
            Text(text = "Text 3", modifier = Modifier.background(BlueContrast).padding(20.dp).weight(1f), color = BlogGreen)
        }
    }
}