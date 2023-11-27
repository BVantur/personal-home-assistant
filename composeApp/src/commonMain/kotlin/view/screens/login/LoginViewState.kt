package view.screens.login

import androidx.compose.ui.text.input.TextFieldValue
import data.models.TextData
import view.components.DialogData

data class LoginViewState(
    val isLoading: Boolean = false,
    val email: TextFieldValue = TextFieldValue("blaz.vantur@gmail.com"),
    val password: TextFieldValue = TextFieldValue("Test1234!1"),
    val emailError: TextData? = null,
    val passwordError: TextData? = null,
    val loginDialogData: DialogData? = null
)
