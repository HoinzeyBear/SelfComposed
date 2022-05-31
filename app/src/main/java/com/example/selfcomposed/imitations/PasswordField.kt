package com.example.selfcomposed.imitations

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.selfcomposed.R
import com.example.selfcomposed.ui.theme.BrightGreen
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun PasswordField() {
    val viewModel: PasswordFieldViewModel = viewModel()
    MaterialTheme {
        PasswordFieldContent(
            modifier = Modifier.fillMaxSize(),
            state = viewModel.uiState.collectAsState().value,
            handleEvent = viewModel::handleEvent,
        )
    }
}

@Composable
fun PasswordFieldContent(
    modifier: Modifier = Modifier,
    state: PasswordFieldState,
    handleEvent: (event: PasswordFieldEvents) -> Unit,) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        PasswordInput(modifier = Modifier.fillMaxWidth(),
            password = state?.password ?: "",
            onSubmit = {},
            onPasswordChanged = {
                handleEvent(PasswordFieldEvents.PasswordChanged(it))
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        PasswordRequirements(satisfiedRequirements = state.passwordRequirements)
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
    }, trailingIcon = {
            IconButton(onClick = {
                isPasswordHidden = !isPasswordHidden
            }) {
                if(isPasswordHidden) {
                    Icon(painter = painterResource(id = R.drawable.ic_eye_closed),
                        "Show password")
                } else {
                    Icon(painter = painterResource(id = R.drawable.ic_eye_open),
                        "Hide password")
                }
            }
        },
    visualTransformation = if(isPasswordHidden) {
        PasswordVisualTransformation()
    } else VisualTransformation.None)
}

@Composable
fun PasswordRequirements(
    modifier: Modifier = Modifier,
    satisfiedRequirements: List<PasswordRequirements>) {

    Column(modifier = modifier) {
        PasswordRequirements.values().forEach { req ->
            RequirementEntry(label = stringResource(id=req.label),
                satisfied = satisfiedRequirements.contains(req))
        }
    }
}

@Composable
fun RequirementEntry(
    modifier: Modifier = Modifier,
    label: String,
    satisfied: Boolean) {

    val requirementStatus = if (satisfied) {
        stringResource(id = R.string.imi_password_requirement_satisfied, label)
    } else {
        stringResource(id = R.string.imi_password_requirement_needed, label)
    }

    val tint = if(satisfied) {
        BrightGreen
    } else
        MaterialTheme.colors.error
//        MaterialTheme.colors.onSurface.copy(alpha = 0.4f)

    Row(
        modifier = modifier.padding(6.dp)
            .semantics(mergeDescendants = true) { text = AnnotatedString(requirementStatus) },
        verticalAlignment = Alignment.CenterVertically) {

        Icon(
            modifier = Modifier.size(12.dp),
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = tint
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(modifier = Modifier.clearAndSetSemantics {  } ,
            text = label,
            fontSize = 12.sp,
            color = tint
        )
    }
}

data class PasswordFieldState(
    val password: String? = null,
    val passwordRequirements: List<PasswordRequirements> = emptyList()
)

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
        val requirements = mutableListOf<PasswordRequirements>()
        if (password.length > 7) {
            requirements.add(PasswordRequirements.EIGHT_CHARACTERS)
        }
        if (password.any { it.isUpperCase() }) {
            requirements.add(PasswordRequirements.CAPITAL_LETTER)
        }
        if (password.any { it.isDigit() }) {
            requirements.add(PasswordRequirements.NUMBER)
        }

        uiState.value = uiState.value.copy(
            password = password,
            passwordRequirements = requirements.toList())
    }
}

enum class PasswordRequirements(@StringRes val label: Int){
    CAPITAL_LETTER(R.string.imi_password_capital_letter_required),
    NUMBER(R.string.imi_number_required),
    EIGHT_CHARACTERS(R.string.imi_8_characters_required)
}