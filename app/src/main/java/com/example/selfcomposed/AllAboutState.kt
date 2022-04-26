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


@Composable
fun Stateful() {
    Surface(modifier = Modifier.fillMaxSize()) {

        Row(modifier = Modifier.background(color = MaterialTheme.colors.surface), horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {

            var oddNumber = 1
            OddButton(oddNumber = oddNumber) {
                oddNumber += 1
            }

            var evenNumber = 2
            EvenButton(evenNumber = evenNumber) {
                evenNumber += 2
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