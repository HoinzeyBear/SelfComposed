package com.example.selfcomposed.blog

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.selfcomposed.ui.theme.*

@Preview(name = "Playground")
@Composable
fun Playground() {

    Surface(
        color = MaterialTheme.colors.surface, // Background essentially
        contentColor = Purple700, // Color for the text in this scenario but is overridden if text defines its own color
        border = BorderStroke(5.dp, Purple700), //Well, its a border
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Text 1",
            modifier = Modifier
//            .background(OrangeHighlight)
            .padding(20.dp),
//            color = BlogGreen
        )

//        Text(text = "Text 2", modifier = Modifier.background(PurplyBlueContrast)
//            .padding(20.dp), color = BlogGreen)
    }
}

@Preview(name = "Shapes")
@Composable
fun SurfaceShapes() {
    Row(modifier = Modifier
        .background(Color.LightGray)
        .padding(5.dp)
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround) {

        Surface(shape = CircleShape){
            Text(text = "Text 1", modifier = Modifier
                .background(OrangeHighlight)
                .padding(8.dp), color = BlogGreen)
        }

        Surface(shape = RoundedCornerShape(12.dp)){
            Text(text = "Text 2", modifier = Modifier
                .background(PurplyBlueContrast)
                .padding(8.dp), color = BlogGreen)
        }

        Surface(shape = RoundedCornerShape(0.dp, 0.dp, 25.dp, 25.dp)){
            Text(text = "Text 2", modifier = Modifier
                .background(PurplyBlueContrast)
                .padding(8.dp), color = BlogGreen)
        }

        Surface(shape = RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp)){
            Text(text = "Text 2", modifier = Modifier
                .background(PurplyBlueContrast)
                .padding(8.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Elevation")
@Composable
fun Elevations() {
    Row(modifier = Modifier
        .background(MaterialTheme.colors.surface)
        .padding(5.dp),
        horizontalArrangement = Arrangement.Start) {

        Surface(shape = RoundedCornerShape(12.dp)){
            Text(text = "Text 1", modifier = Modifier
                .background(OrangeHighlight)
                .padding(8.dp), color = BlogGreen)
        }

        Surface(
            modifier = Modifier.padding(start = 4.dp),
            shape = RoundedCornerShape(12.dp),
            elevation = 12.dp){
            Text(text = "Text 2", modifier = Modifier
                .padding(8.dp), color = BlogGreen)
        }

        Surface(Modifier.padding(start = 4.dp), shape = RoundedCornerShape(12.dp)){
            Text(text = "Text 3", modifier = Modifier
                .background(PurplyBlueContrast)
                .padding(8.dp), color = BlogGreen)
        }
    }
}

@Preview(name = "Border")
@Composable
fun Border() {

    Surface(
        color = MaterialTheme.colors.surface, // Background essentially
        contentColor = Purple700, // Color for the text in this scenario but is overridden if text defines its own color
        border = BorderStroke(1.dp, OrangeHighlight), //Well, its a border
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Text 1",
            modifier = Modifier
                .padding(5.dp),
            color = BlueContrast
        )
    }
}