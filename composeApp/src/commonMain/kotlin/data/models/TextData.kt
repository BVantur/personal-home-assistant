package data.models

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.compose.stringResource

sealed class TextData {
    data class DynamicString(val value: String?): TextData()
    data class StringRes(
        val id: StringResource,
        val args: List<Any> = emptyList()
    ): TextData()

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> this.value ?: ""
            is StringRes -> stringResource(id)
        }
    }
}