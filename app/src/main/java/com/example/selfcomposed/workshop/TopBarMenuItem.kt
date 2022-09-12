package com.example.selfcomposed.workshop

import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBarMenu() {
    TopAppBar(
        title = {
            Text(text = "Top App bar")
        },
        actions = {
            TopBarMenuWithSubMenu()
        }
    )
    Text(text = "Body of page")
}


@Composable
fun TopBarMenuWithSubMenu() {
    TopAppBar() {
        var menuExpanded by remember { mutableStateOf(false)}
        var subMenuExpanded by remember { mutableStateOf(false)}
        IconButton(onClick = { menuExpanded = true}) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "")
        }
        DropdownMenu(expanded = menuExpanded, onDismissRequest = {menuExpanded = false}) {
            DropdownMenuItem(onClick = {  }) {
                Text(text = "Option 1")
            }
            DropdownMenuItem(onClick = {  }) {
                Text(text = "Option 2")
            }

            Text(modifier = Modifier.clickable {
                subMenuExpanded = true
            },text = "Sub menu")

            DropdownMenu(expanded = subMenuExpanded, onDismissRequest = {subMenuExpanded = false}) {
                DropdownMenuItem(onClick = {  }) {
                    Text(text = "Sub-Option 1")
                }
                DropdownMenuItem(onClick = {  }) {
                    Text(text = "Sub-Option 2")
                }
            }
        }
    }
}


@Preview(name = "Top bar")
@Composable
fun PreviewTopBarMenu() {
    Surface {
        TopBarMenu()
    }
}