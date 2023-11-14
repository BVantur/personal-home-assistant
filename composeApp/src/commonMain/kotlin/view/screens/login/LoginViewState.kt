package view.screens.login

import androidx.compose.ui.text.input.TextFieldValue

data class LoginViewState(
    val isLoading: Boolean = false,
    val email: TextFieldValue = TextFieldValue(""),
    val password: TextFieldValue = TextFieldValue("")
)
