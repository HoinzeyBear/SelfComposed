package com.example.selfcomposed.stackoverflow

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Checkbox
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CheckboxInRowWithText() {
    var checkedState by remember { mutableStateOf(false) }
    Surface {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    checkedState = !checkedState
                },
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checkedState,
                onCheckedChange = {} )

            Text(text = "Clicking this Row will toggle checkbox")
        }
    }
}

/*
https://stackoverflow.com/questions/76226889/android-compose-why-does-checkbox-need-oncheckchanged-when-parent-is-clickable
 */
@Composable
fun CheckboxInRowWithTextAnswer1() {
    var checkedState by remember { mutableStateOf(false) }
    Surface {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    checkedState = !checkedState
                },
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checkedState,
                onCheckedChange = {
                    checkedState = it
                } )

            Text(text = "Clicking this Row will toggle checkbox")
        }
    }
}