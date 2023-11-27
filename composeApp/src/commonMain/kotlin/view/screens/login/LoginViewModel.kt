package view.screens.login

import androidx.compose.ui.text.input.TextFieldValue
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import cafe.adriel.voyager.navigator.Navigator
import data.models.ResourceResult
import data.models.TextData
import domain.errors.LoginErrors
import domain.usecase.EmailValidationUseCase
import domain.usecase.LoginWithGoogleUseCase
import domain.usecase.PasswordValidationUseCase
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sp.bvantur.assistant.SharedRes
import utils.DispatcherProvider
import view.components.DialogData
import view.screens.home.HomeScreen

class LoginViewModel(
    private val navigator: Navigator,
    private val loginWithGoogleUseCase: LoginWithGoogleUseCase,
    private val emailValidationUseCase: EmailValidationUseCase,
    private val passwordValidationUseCase: PasswordValidationUseCase,
    private val dispatcherProvider: DispatcherProvider
) : StateScreenModel<LoginViewState>(LoginViewState()) {

    fun onEmailLoginAction() {
        screenModelScope.launch(dispatcherProvider.main) {
            val email = state.value.email.text
            val password = state.value.password.text
            val emailError = emailValidationUseCase(email)
            val passwordError = passwordValidationUseCase(password)

            val isThereAnError = emailError != null || passwordError != null

            if (isThereAnError) {
                mutableState.update {
                    it.copy(
                        emailError = emailError,
                        passwordError = passwordError
                    )
                }
                return@launch
            }

            loginWithGoogleUseCase(dispatcherProvider.io, state.value.email.text, state.value.password.text).collectLatest { result ->
                when (result) {
                    is ResourceResult.Error -> {
                        var newViewState = mutableState.value.copy(isLoading = false)

                        when (result.throwable) {
                            is LoginErrors.InvalidCredentials -> {
                                newViewState = newViewState.copy(loginDialogData = DialogData(
                                        title = TextData.StringRes(SharedRes.strings.error),
                                        message = TextData.StringRes(SharedRes.strings.wrong_credentials_message),
                                        positiveAction = TextData.StringRes(SharedRes.strings.close),
                                        onPositiveAction = {
                                            mutableState.update {
                                                it.copy(loginDialogData = null)
                                            }
                                        }
                                    ))

                            }
                            else -> {
                                 // TODO fix this dialog
                                newViewState = newViewState.copy(loginDialogData = DialogData(
                                    title = TextData.StringRes(SharedRes.strings.error),
                                    message = TextData.StringRes(SharedRes.strings.wrong_credentials_message),
                                    positiveAction = TextData.StringRes(SharedRes.strings.close),
                                    onPositiveAction = {
                                        mutableState.update {
                                            it.copy(loginDialogData = null)
                                        }
                                    }
                                ))
                            }
                        }
                        mutableState.update {
                            newViewState
                        }
                    }

                    ResourceResult.Loading -> {
                        mutableState.update {
                            it.copy(isLoading = true)
                        }
                    }

                    is ResourceResult.Success -> {
                        mutableState.update {
                            it.copy(isLoading = false)
                        }
                        navigator.replace(HomeScreen)
                    }

                }
            }
        }
    }

    fun onEmailValueChanged(newValue: TextFieldValue) {
        screenModelScope.launch(dispatcherProvider.main) {
            var errorText = state.value.emailError
            if (errorText != null) {
                errorText = emailValidationUseCase(newValue.text)
            }
            mutableState.update {
                it.copy(
                    email = newValue,
                    emailError = errorText
                )
            }
        }
    }

    fun onPasswordValueChanged(newValue: TextFieldValue) {
        screenModelScope.launch(dispatcherProvider.main) {
            var errorText = state.value.passwordError
            if (errorText != null) {
                errorText = passwordValidationUseCase(newValue.text)
            }
            mutableState.update {
                it.copy(
                    password = newValue,
                    passwordError = errorText
                )
            }
        }
    }
}