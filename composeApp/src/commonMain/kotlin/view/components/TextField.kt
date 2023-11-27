package view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import data.models.TextData
import dev.icerock.moko.resources.compose.painterResource
import sp.bvantur.assistant.SharedRes

@Composable
private fun BaseTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    enabled: Boolean = true,
    errorMessage: TextData? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (TextFieldValue) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Column {
        OutlinedTextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            enabled = enabled,
            label = placeholder,
            visualTransformation = visualTransformation,
            trailingIcon = trailingIcon,
            isError = errorMessage != null,
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colors.onSurface,
                backgroundColor = MaterialTheme.colors.surface
            )
        )
        errorMessage?.apply {
            Body2Text(
                modifier = Modifier.padding(top = 4.dp),
                color = MaterialTheme.colors.error,
                text = errorMessage.asString()
            )
        }
    }
}

@Composable
fun PHATextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    enabled: Boolean = true,
    errorMessage: TextData? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (TextFieldValue) -> Unit
) {
    BaseTextField(
        modifier = modifier,
        value = value,
        enabled = enabled,
        errorMessage = errorMessage,
        placeholder = placeholder,
        onValueChange = onValueChange
    )
}

@Composable
fun PHAPasswordTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    enabled: Boolean = true,
    errorMessage: TextData? = null,
    placeholder: @Composable (() -> Unit)? = null,
    onValueChange: (TextFieldValue) -> Unit
) {
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    BaseTextField(
        modifier = modifier,
        value = value,
        enabled = enabled,
        errorMessage = errorMessage,
        placeholder = placeholder,
        onValueChange = onValueChange,
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            val visibilityIcon =
                if (passwordHidden) painterResource(SharedRes.images.password_visibility_on) else painterResource(SharedRes.images.password_visibility_off)
            Image(
                modifier = Modifier.clickable {
                    passwordHidden = !passwordHidden
                },
                painter = visibilityIcon,
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onSurface)
            )
        }
    )
}