package com.example.selfcomposed

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.selfcomposed.ui.theme.OrangeHighlight
import com.example.selfcomposed.ui.theme.PurplyBlueContrast

/*
    https://dev.to/zachklipp/scoped-recomposition-jetpack-compose-what-happens-when-state-changes-l78
 */

@Composable
fun Stateful() {
    Surface(modifier = Modifier.fillMaxSize()) {
        println("Drawing surface")
        val oddNumber: MutableState<Int> = remember { mutableStateOf(1) }
        var evenNumber by remember{ mutableStateOf(2) }

        Row(modifier = Modifier.background(color = MaterialTheme.colors.surface), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
//            println("Drawing row")
//
//            OddButton(oddNumber
//
//
//
//            {
//                oddNumber.
            EvenButton(evenNumber = evenNumber) {
                evenNumber += 2
            }
        }
    }
}

@Composable
fun StartingPoint() {
    /*
    On first render, all 4 "Drawing" messages are printed. Surface -> Row -> OddButton -> EvenButton

    Your intuition may be that when the OddButton is pressed, only the OddButton is recomposed but this isn't
    the case. You get: Surface -> Row -> OddButton all getting recomposed. Why though? This seems a bit much

    Answer lies in recompose scopes. The entirety of the nearest scope to those changes will be recomposed.
    Q: So Shouldn't that just be Row? Or even just the Button ?
    A: Common layouts such as Column, Row & Box are _inline_ functions. As inline functions are basically copied
    to the calling site on compile, they don't have their own scope. So our Surface is the nearest compose scope.
     */
    Surface(modifier = Modifier.fillMaxSize()) {
        println("Drawing surface")

        Row(modifier = Modifier.background(color = MaterialTheme.colors.surface), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            println("Drawing row")

            val oddNumber: MutableState<Int> = remember { mutableStateOf(1) }
            OddButton(oddNumber = oddNumber.value) {
                oddNumber.value += 2
            }

            var evenNumber by remember{ mutableStateOf(2) }
            EvenButton(evenNumber = evenNumber) {
                evenNumber += 2
            }
        }
    }
}

@Composable
fun StartingPoint_ExtraSurface() {
    /*
        Here the "second surface" is the nearest scope, so it prevents the Row & First surface being recomposed.
        It does bork the layout however and in this scenario, would offer no benefit.
     */
    Surface(modifier = Modifier.fillMaxSize()) {
        println("Drawing surface")

        Row(modifier = Modifier.background(color = MaterialTheme.colors.surface), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            println("Drawing row")
            Surface(){
                println("Drawing second surface")
                val oddNumber: MutableState<Int> = remember { mutableStateOf(1) }
                OddButton(oddNumber = oddNumber.value) {
                    oddNumber.value += 2
                }

                var evenNumber by remember{ mutableStateOf(2) }
                EvenButton(evenNumber = evenNumber) {
                    evenNumber += 2
                }
            }
        }
    }
}

data class TwoButtonsState(var oddNumber: Int, var evenNumber: Int)

@Composable
fun StartingPoint_WithDataClassAsState() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val state: MutableState<TwoButtonsState> = remember { mutableStateOf(TwoButtonsState(oddNumber = 1, evenNumber = 2)) }
        println("Drawing surface")

        Row(modifier = Modifier.background(color = MaterialTheme.colors.surface), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            println("Drawing row")

            OddButton(oddNumber = state.value.oddNumber) {
                state.value = state.value.copy(oddNumber = (state.value.oddNumber + 2))
            }

            EvenButton(evenNumber = state.value.evenNumber) {
                state.value = state.value.copy(evenNumber = (state.value.evenNumber + 2))
            }
        }
    }
}

class TwoButtonWithStateFields() {
    val oddNumber = mutableStateOf(1)
    val evenNumber = mutableStateOf(2)
}

@Composable
fun StartingPoint_WithClassOfStateFields() {

    val obj = TwoButtonWithStateFields()
    Surface(modifier = Modifier.fillMaxSize()) {
        /*
        val obj = TwoButtonWithStateFields()
        => If this is declared here, as the above surface is the nearest compose scope
            the object is recreated each time, resulting in the values not changing on UI
         */
        println("Drawing surface")

        Row(modifier = Modifier.background(color = MaterialTheme.colors.surface), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            println("Drawing row")

            OddButton(oddNumber = obj.oddNumber.value) {
                obj.oddNumber.value = obj.oddNumber.value + 2
            }

            EvenButton(evenNumber = obj.evenNumber.value) {
                obj.evenNumber.value = obj.evenNumber.value + 2
            }
        }
    }
}


@Composable
fun OddButton(oddNumber: Int, increaseOdd: () -> Unit) {
    Button(modifier = Modifier
        .padding(end = 5.dp)
        .background(OrangeHighlight),
        onClick = {
            increaseOdd()
            println("Odd number is now: $oddNumber")
        }) {
        println("Drawing odd button")
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Odd number !")
            Text(text = "$oddNumber")
        }
    }
}

@Composable
fun EvenButton(evenNumber: Int, increaseEven: () -> Unit) {
    Button(modifier = Modifier
        .padding(start = 5.dp)
        .background(PurplyBlueContrast),
        onClick = {
            increaseEven()
            println("Even number is now: $evenNumber")
        }) {
        println("Drawing even button")
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Even number !")
            Text(text = "$evenNumber")
        }
    }
}