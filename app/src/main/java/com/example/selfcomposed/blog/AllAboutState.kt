package com.example.selfcomposed.blog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.selfcomposed.ui.theme.GreenContrast
import com.example.selfcomposed.ui.theme.OrangeHighlight
import com.example.selfcomposed.ui.theme.PurplyBlueContrast
import com.example.selfcomposed.util.AllAboutStateUtil

/*
    https://dev.to/zachklipp/scoped-recomposition-jetpack-compose-what-happens-when-state-changes-l78
 */

@Composable
fun AllAboutState() {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top) {
        println("Drawing AllAboutState Column")

        Text(text = "State variables are ints declared within the scope of the composable." +
                "The nearest recompose is the surface",
            modifier = Modifier.padding(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(PurplyBlueContrast)
            .padding(top = 10.dp)) {
            StartingPoint(Modifier.background(PurplyBlueContrast))
        }
        Text(text = "State variables are ints declared within the scope of the composable." +
                "The nearest recompose is the surface closer to the buttons, but this wrecks " +
                "the layout",
            modifier = Modifier.padding(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(GreenContrast)
            .padding(top = 10.dp)) {
            StartingPoint_ExtraSurface(Modifier.background(GreenContrast))
        }
        Text(text = "State is an instance of a data class containing the 2 ints",
            modifier = Modifier.padding(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(PurplyBlueContrast)
            .padding(top = 10.dp)) {
            StartingPoint_WithDataClassAsState(Modifier.background(PurplyBlueContrast))
        }
        Text(text = "State is an instance of a regular class containing " +
                "the 2 fields of type mutableState",
            modifier = Modifier.padding(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(GreenContrast)
            .padding(top = 10.dp)) {
            StartingPoint_WithClassOfStateFields(Modifier.background(GreenContrast))
        }
        Text(text = "State is an instance of a regular class containing " +
                "the 2 fields of type mutableState",
            modifier = Modifier.padding(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(PurplyBlueContrast)
            .padding(top = 10.dp)) {
            MutableListDonts()
        }
        Text(text = "State is an instance of a regular class containing " +
                "the 2 fields of type mutableState",
            modifier = Modifier.padding(5.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(GreenContrast)
            .padding(top = 10.dp)) {
            println("Drawing Row for List DOS")
            MutableListDos()
        }

    }
}

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
fun StartingPoint(modifier: Modifier = Modifier) {
    /*
    On first render, all 4 "Drawing" messages are printed. Surface -> Row -> OddButton -> EvenButton

    Your intuition may be that when the OddButton is pressed, only the OddButton is recomposed but this isn't
    the case. You get: Surface -> Row -> OddButton all getting recomposed. Why though? This seems a bit much

    Answer lies in recompose scopes. The entirety of the nearest scope to those changes will be recomposed.
    Q: So Shouldn't that just be Row? Or even just the Button ?
    A: Common layouts such as Column, Row & Box are _inline_ functions. As inline functions are basically copied
    to the calling site on compile, they don't have their own scope. So our Surface is the nearest compose scope.
     */
    Surface {
        println("Drawing surface")

        Row(modifier = modifier, horizontalArrangement = Arrangement.Center,
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
fun StartingPoint_ExtraSurface(modifier: Modifier = Modifier) {
    /*
        Here the "second surface" is the nearest scope, so it prevents the Row & First surface being recomposed.
        It does bork the layout however and in this scenario, would offer no benefit.
     */
    Surface {
        println("Drawing surface")

        Row(modifier = modifier, horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            println("Drawing row")
            Surface(modifier = modifier){
                println("Drawing second surface")
                val oddNumber: MutableState<Int> = remember { mutableStateOf(1) }
                OddButton(oddNumber = oddNumber.value) {
                    oddNumber.value += 2
                }

                var evenNumber by remember{ mutableStateOf(2) }
                EvenButton(Modifier.padding(start = 240.dp), evenNumber = evenNumber) {
                    evenNumber += 2
                }
            }
        }
    }
}

data class TwoButtonsState(var oddNumber: Int, var evenNumber: Int)

@Composable
fun StartingPoint_WithDataClassAsState(modifier: Modifier = Modifier) {
    Surface {
        val state: MutableState<TwoButtonsState> = remember { mutableStateOf(TwoButtonsState(oddNumber = 1, evenNumber = 2)) }
        println("Drawing surface")

        Row(modifier = modifier,
            horizontalArrangement = Arrangement.Center,
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
fun StartingPoint_WithClassOfStateFields(modifier: Modifier = Modifier) {

    val obj = TwoButtonWithStateFields()
    Surface {
        /*
        val obj = TwoButtonWithStateFields()
        => If this is declared here, as the above surface is the nearest compose scope
            the object is recreated each time, resulting in the values not changing on UI
         */
        println("Drawing surface")

        Row(modifier = modifier, horizontalArrangement = Arrangement.Center,
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
fun MutableListDonts(modifier: Modifier = Modifier) {
    println("Creating list")
    val list by remember{mutableStateOf(listOf("a"))}
    println("Drawing DONT list button")
    ListButton(list = list){
        list.plus("b")
    }
}

@Composable
fun MutableListDos(modifier: Modifier = Modifier) {
    /*
        todo get a better understanding of why the firstList triggers a recomposition of all 3
        list buttons whereas the 2nd + 3rd manage to trigger an update without triggering any re-compose calls ?
     */
    println("Creating list")
    var firstList by remember{mutableStateOf(listOf("a"))}
    val secondList: SnapshotStateList<String> = remember{ mutableStateListOf("a") }
    //val firstList by remember{mutableStateOf(mutableListOf("a"))} - it doesn't like this
    val thirdList: MutableList<String> = remember{mutableStateListOf("a")}

    Row(modifier = modifier, horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        println("Drawing first DO list button")
        ListButton(list = firstList){
            firstList = firstList.plus("b")
        }
//        firstList.add("b")
        println("Drawing second DO list button")
        ListButton(list = secondList){
            secondList.add("b")
        }
        println("Drawing third DO list button")
        ListButton(list = thirdList){
            thirdList.add("b")
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
fun EvenButton(modifier: Modifier = Modifier,evenNumber: Int, increaseEven: () -> Unit) {
    Button(modifier = modifier
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

@Composable
fun ListButton(modifier: Modifier = Modifier,list: List<String>, add: () -> Unit) {
    println("Drawing List button")
    Button(modifier = modifier
        .padding(start = 5.dp)
        .background(PurplyBlueContrast),
        onClick = {
            add()
            println("Size of list is now: ${list.size}")
        }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "List button !")
            Text(text = AllAboutStateUtil.alphabet[list.size-1])
        }
    }
}

@Preview
@Composable
fun PreviewAllAboutState() {
    AllAboutState()
}