package com.example.selfcomposed.imitations

import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
    Box(modifier = Modifier
        .fillMaxSize()) {

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

    val transition = updateTransition(targetState = fabState, label = "fab_transitions")
    val rotation: Float by transition.animateFloat(label = "fab_rotation") { s: MultiFabState ->
        if (s == MultiFabState.EXPANDED) 45f else 0f
    }

    FloatingActionButton(
        modifier = modifier
            .padding(15.dp)
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




enum class MultiFabState {
    COLLAPSED, EXPANDED
}



