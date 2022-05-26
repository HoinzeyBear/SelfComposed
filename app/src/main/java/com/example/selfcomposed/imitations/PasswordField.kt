package com.example.selfcomposed.imitations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun PasswordField() {
    val viewModel: PasswordFieldViewModel = viewModel()
    MaterialTheme {
        PasswordFieldContent(
            modifier = Modifier.fillMaxSize(),
            state = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent
        )
    }
}

@Composable
fun PasswordFieldContent(
    modifier: Modifier = Modifier,
    state: PasswordFieldState,
    handleEvent: (event: PasswordFieldEvents) -> Unit) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        PasswordInput(modifier = Modifier.fillMaxWidth(),
        password = state?.password ?: "",
        onSubmit = {},
        onPasswordChanged = {
            handleEvent(PasswordFieldEvents.PasswordChanged(it))
        })
    }
}

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    password: String,
    onSubmit: () -> Unit,
    onPasswordChanged: (password: String) -> Unit) {

    var isPasswordHidden by remember {
        mutableStateOf(true)
    }

    TextField(value = password,
        onValueChange = {
            onPasswordChanged(it)
        },
    label = {
        Text(text = "Password")
    },
    leadingIcon = {
        Icon(imageVector = Icons.Default.Lock,
        "Lock icon")
    },
    visualTransformation = if(isPasswordHidden) {
        PasswordVisualTransformation()
    } else VisualTransformation.None)
}

data class PasswordFieldState(val password: String? = null)

sealed class PasswordFieldEvents {

    class PasswordChanged(val password: String): PasswordFieldEvents()

}

class PasswordFieldViewModel: ViewModel() {
    val uiState = MutableStateFlow(PasswordFieldState())

    fun handleEvent(event: PasswordFieldEvents) {
        when(event) {
            is PasswordFieldEvents.PasswordChanged -> {
                updatePassword(event.password)
            }
        }
    }

    private fun updatePassword(password: String) {
        uiState.value = uiState.value.copy(password = password)
    }
}