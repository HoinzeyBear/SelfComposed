package com.example.selfcomposed.blog.coroutines

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


data class ButtonData(var text: String = "Start Benchmark")


private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate)

@Composable
fun CoroutinesCourse() {
    MaterialTheme {
        Main()
    }
}

@Composable
fun Main() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button()
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun Button() {
    val textButtonState = remember {
        mutableStateOf("Execute Benchmark")
    }
    val current = LocalContext.current
    TextButton(
        modifier = Modifier.background(color = Color.Gray),
        onClick = {
        coroutineScope.launch {
            val iterationsCount = executeBenchmark(textButtonState)
            Toast.makeText(current,"$iterationsCount", Toast.LENGTH_SHORT
            ).show()
        }
    }) {
        Text(
            text = textButtonState.value,
            fontSize = TextUnit(14f, TextUnitType.Sp),
            color = Color.White
        )
    }
}

private suspend fun executeBenchmark(textButtonState: MutableState<String>): Long {
    val benchmarkDurationSeconds = 5

    updateRemainingTime(benchmarkDurationSeconds,textButtonState)

    return withContext(Dispatchers.Default) {
        logThreadInfo("benchmark started")

        val stopTimeNano = System.nanoTime() + benchmarkDurationSeconds * 1_000_000_000L

        var iterationsCount: Long = 0
        while (System.nanoTime() < stopTimeNano) {
            iterationsCount++
        }

        logThreadInfo("benchmark completed")

        iterationsCount
    }
}

private fun updateRemainingTime(remainingTimeSeconds: Int, textButtonState: MutableState<String>) {
    logThreadInfo("updateRemainingTime: $remainingTimeSeconds seconds")

    if (remainingTimeSeconds > 0) {
        textButtonState.value = "$remainingTimeSeconds seconds remaining"
        Handler(Looper.getMainLooper()).postDelayed({
            updateRemainingTime(remainingTimeSeconds - 1, textButtonState)
        }, 1000)
    } else {
        textButtonState.value = "done!"
    }
}

private fun logThreadInfo(message: String) {
    ThreadInfoLogger.logThreadInfo(message)
}


object ThreadInfoLogger {

    private const val TAG = "ThreadInfoLogger"

    fun logThreadInfo(message: String) {
        Log.i(
            TAG,
            "$message; thread name: ${Thread.currentThread().name}; thread ID: ${Thread.currentThread().id}"
        )
    }

}