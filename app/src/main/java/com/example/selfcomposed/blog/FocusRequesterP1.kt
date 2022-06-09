package com.example.selfcomposed.blog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//First name Second Name Address 1 Address 2
@Composable
fun KeyboardInputToNextFormField() {
    MaterialTheme {
        FormContent(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun FormContent(modifier: Modifier) {
    Column(modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally) {

        val firstNameFocusRequester = remember { FocusRequester() }
        val secondNameFocusRequester = remember { FocusRequester() }
        val address1FocusRequester = remember { FocusRequester() }
        val address2FocusRequester = remember { FocusRequester() }

        val focusManager = LocalFocusManager.current

        FormTextField(
            modifier = Modifier.focusRequester(firstNameFocusRequester),
            value = "",
            label = "First name",
            onNextClicked = {secondNameFocusRequester.requestFocus()})

        FormTextField(
            modifier = Modifier.focusRequester(secondNameFocusRequester),
            value = "",
            label = "Second name",
            onNextClicked = {address1FocusRequester.requestFocus()})

        FormTextField(
            modifier = Modifier.focusRequester(address1FocusRequester),
            value = "",
            label = "Address 1",
            onNextClicked = {focusManager.moveFocus(FocusDirection.Down)})

        FormTextField(
            modifier = Modifier.focusRequester(address2FocusRequester),
            value = "",
            label = "Address 2",
            onNextClicked = {focusManager.clearFocus()})

        LaunchedEffect(Unit) {
            firstNameFocusRequester.requestFocus()
        }
    }
}

@Composable
fun FormTextField(
    modifier: Modifier,
    value: String,
    label: String,
    onNextClicked: () -> Unit) {

    var input by remember { mutableStateOf(value) }
    TextField(
       modifier = modifier.padding(20.dp) ,
        value = input,
        onValueChange = {input = it},
        label = {
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(onNext = {onNextClicked()})
    )
}

@Preview(name = "Form preview")
@Composable
fun FormPreview() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        KeyboardInputToNextFormField()
    }
}