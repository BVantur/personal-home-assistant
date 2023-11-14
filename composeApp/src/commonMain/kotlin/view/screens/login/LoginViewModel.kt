package view.screens.login

import androidx.compose.ui.text.input.TextFieldValue
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import cafe.adriel.voyager.core.model.screenModelScope
import cafe.adriel.voyager.navigator.Navigator
import data.models.ResourceResult
import domain.usecase.LoginWithGoogleUseCase
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import utils.DispatcherProvider
import view.screens.home.HomeScreen

class LoginViewModel(
    private val navigator: Navigator,
    private val loginWithGoogleUseCase: LoginWithGoogleUseCase,
    private val dispatcherProvider: DispatcherProvider
) : StateScreenModel<LoginViewState>(LoginViewState()) {

    fun onGoogleLoginAction() {
        screenModelScope.launch(dispatcherProvider.main) {
            loginWithGoogleUseCase(dispatcherProvider.io).collectLatest { result ->
                when (result) {
                    is ResourceResult.Error -> {
                        mutableState.update {
                            it.copy(isLoading = false)
                        }
                        // TODO handle error
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
            mutableState.update {
                it.copy(email = newValue)
            }
        }
    }

    fun onPasswordValueChanged(newValue: TextFieldValue) {
        screenModelScope.launch(dispatcherProvider.main) {
            mutableState.update {
                it.copy(password = newValue)
            }
        }
    }
}