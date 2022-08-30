package com.example.selfcomposed.imitations

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Twitter() {
    MaterialTheme {
        MainContainer(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun MainContainer(modifier: Modifier) {
    /*
    Stuff for the lists etc
     */
    Box(modifier = modifier) {

        var fabState by remember { mutableStateOf(MultiFabState.COLLAPSED) }
        if(fabState == MultiFabState.EXPANDED) {
            OpacityScreen(modifier = Modifier
                .fillMaxSize()
                .alpha(0.3F)
                .background(color = Color.Blue))
        }

        ActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            onStateChanged = { newState -> fabState = newState },
            fabState = fabState)
    }
}

@Composable
fun OpacityScreen(modifier: Modifier) {
    Box(modifier = modifier) {}
}

@Composable
fun ActionButton(
    modifier: Modifier,
    onStateChanged: (fabState: MultiFabState) -> Unit,
    fabState: MultiFabState
) {

    Column(modifier ,horizontalAlignment = Alignment.End) {
        val transition = updateTransition(targetState = fabState, label = "fab_transitions")
        val rotation: Float by transition.animateFloat(label = "fab_rotation") { s: MultiFabState ->
            if (s == MultiFabState.EXPANDED) 45f else 0f
        }

        val scale: Float by transition.animateFloat { state ->
            if (state == MultiFabState.EXPANDED) 56f else 0f
        }

        val alpha: Float by transition.animateFloat(transitionSpec = {
            tween(durationMillis = 20)
        }, label = "") { state ->
            if (state == MultiFabState.EXPANDED) 1f else 0f
        }

        if (transition.currentState == MultiFabState.EXPANDED) {
            MiniFloatingActionButton(MultiFabItem("stuff",
//                icon = bitmap!!,
                label = "Spaces"), onFabItemClicked =  {}, buttonScale = scale, iconAlpha = alpha)
            Spacer(modifier = Modifier.height(10.dp))
            MiniFloatingActionButton(MultiFabItem("stuff",
//                icon = bitmap!!,
                label = "Photo"), onFabItemClicked =  {}, buttonScale = scale, iconAlpha = alpha)
            Spacer(modifier = Modifier.height(10.dp))
            MiniFloatingActionButton(MultiFabItem("stuff",
//                icon = bitmap!!,
                label = "Gif"), onFabItemClicked =  {}, buttonScale = scale, iconAlpha = alpha)
            Spacer(modifier = Modifier.height(10.dp))
        }

        FloatingActionButton(
            modifier = modifier
                .padding(end = 12.dp, bottom = 10.dp)
                .rotate(rotation),
            onClick = {
                onStateChanged(
                    if (transition.currentState == MultiFabState.EXPANDED) {
                        MultiFabState.COLLAPSED
                    } else MultiFabState.EXPANDED)
            },
            backgroundColor = Color.Green) {

            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Default.Add,
                contentDescription = null)
        }
    }

}

@Composable
private fun MiniFloatingActionButton(
    item: MultiFabItem,
    buttonScale: Float,
    iconAlpha: Float,
    onFabItemClicked: (item: MultiFabItem) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end = 21.dp)
    ) {
        Text(
            item.label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .alpha(animateFloatAsState(iconAlpha).value)
                .background(color = MaterialTheme.colors.surface)
                .padding(start = 6.dp, end = 6.dp, top = 4.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        IconButton(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = Color.LightGray),
            onClick = {  }) {
        }
    }
}

@Preview(name = "Fab stack")
@Composable
fun PreviewFabStack() {
    Box(modifier = Modifier.fillMaxSize()) {
        ActionButton(modifier = Modifier.align(Alignment.BottomEnd),
            onStateChanged = {  },
            fabState = MultiFabState.EXPANDED)
    }
}
/*
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
 */


enum class MultiFabState {
    COLLAPSED, EXPANDED
}



