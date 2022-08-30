package com.example.selfcomposed.workshop

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBarMenu() {
    TopAppBar(
        title = {
            Text(text = "Top App bar")
        },
        actions = {
            
        }
    )
}


@Composable
fun TopBarMenuWithSubMenu() {
    TopAppBar() {

    }
}


@Preview(name = "Top bar")
@Composable
fun PreviewTopBarMenu() {
    Surface {
        TopBarMenu()
    }
}