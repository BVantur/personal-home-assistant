package view.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import org.koin.core.parameter.ParametersHolder
import sp.bvantur.assistant.SharedRes
import view.components.Body1Text
import view.components.ButtonText
import view.components.H4Text
import view.components.Loader
import view.components.PHAButton
import view.components.PHATextField
import view.theme.PHATheme

object LoginScreen : Screen {

    @Composable
    override fun Content() {
        PHATheme {
            val currentNavigator = LocalNavigator.currentOrThrow
            val screenModel = getScreenModel<LoginViewModel>(
                parameters = { ParametersHolder(listOf(currentNavigator).toMutableList(), false) }
            )
            val viewState by screenModel.state.collectAsState()
            LoginContent(
                viewState = viewState,
                onGoogleLoginClick = screenModel::onGoogleLoginAction,
                onEmailTextChanged = screenModel::onEmailValueChanged,
                onPasswordTextChanged = screenModel::onPasswordValueChanged
            )
        }
    }
}

@Composable
fun LoginContent(
    viewState: LoginViewState,
    onGoogleLoginClick: () -> Unit,
    onEmailTextChanged: (TextFieldValue) -> Unit,
    onPasswordTextChanged: (TextFieldValue) -> Unit
) {
    Scaffold {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    modifier = Modifier.fillMaxWidth(0.35f).fillMaxHeight(0.35f),
                    painter = painterResource(SharedRes.images.intro_shopping_assistant),
                    contentDescription = null
                )

                H4Text(
                    text = stringResource(SharedRes.strings.app_name)
                )

                PHATextField(
                    value = viewState.email,
                    onValueChange = { newValue ->
                        onEmailTextChanged(newValue)
                    },
                    placeholder = {
                        Body1Text(
                            text = stringResource(SharedRes.strings.email)
                        )
                    }
                )

                PHATextField(
                    value = viewState.password,
                    onValueChange = { newValue ->
                        onPasswordTextChanged(newValue)
                    },
                    placeholder = {
                        Body1Text(
                            text = stringResource(SharedRes.strings.password)
                        )
                    }
                )

                PHAButton(
                    enabled = !viewState.isLoading,
                    onClick = {
                        onGoogleLoginClick()
                    }
                ) {
                    ButtonText(text = stringResource(SharedRes.strings.login))
                }
            }

            if (viewState.isLoading) {
                Loader(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}