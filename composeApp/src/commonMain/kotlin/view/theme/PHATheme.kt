package view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable

// design system: https://www.figma.com/community/file/1008701312536636327/event-booking-app-eventhub

@Composable
fun PHATheme(
    colors: Colors = if(isSystemInDarkTheme()) PHAColors.darkColors() else PHAColors.lightColors(),
    typography: Typography = MaterialTheme.typography,
    shapes: Shapes = MaterialTheme.shapes,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

object TTheme {
    fun theme() {

    }
}