package view.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

// TESLA color palette: https://www.color-hex.com/color-palette/42354

object PHAColors {
    val DodgerBlue = Color(0xFF5669FF)
    val Melrose = Color(0xFF9AA5FF)
    private val Cyan = Color(0xFF00F8FF)
    private val Anakiwa = Color(0xFF99FCFF)
    val Mercury = Color(0xFFE6E6E6)
    private val BurntSienna = Color(0xFFF0635A)
    private val White = Color(0xFFFFFFFF)
    private val Iron = Color(0xFFE7E7E9)
    private val Ebony = Color(0xFF120D26)
    val Charade = Color(0xFF2D2D3A)

    fun lightColors(
        primary: Color = DodgerBlue,
        primaryVariant: Color = Melrose,
        secondary: Color = Cyan,
        secondaryVariant: Color = Anakiwa,
        background: Color = Mercury,
        surface: Color = Mercury,
        error: Color = BurntSienna,
        onPrimary: Color = White,
        onSecondary: Color = Iron,
        onBackground: Color = Ebony,
        onSurface: Color = Ebony,
        onError: Color = Mercury
    ): Colors = Colors(
        primary,
        primaryVariant,
        secondary,
        secondaryVariant,
        background,
        surface,
        error,
        onPrimary,
        onSecondary,
        onBackground,
        onSurface,
        onError,
        true
    )

    fun darkColors(
        primary: Color = DodgerBlue,
        primaryVariant: Color = Melrose,
        secondary: Color = Cyan,
        secondaryVariant: Color = Anakiwa,
        background: Color = Charade,
        surface: Color = Charade,
        error: Color = BurntSienna,
        onPrimary: Color = White,
        onSecondary: Color = Iron,
        onBackground: Color = White,
        onSurface: Color = White,
        onError: Color = Mercury
    ): Colors = Colors(
        primary,
        primaryVariant,
        secondary,
        secondaryVariant,
        background,
        surface,
        error,
        onPrimary,
        onSecondary,
        onBackground,
        onSurface,
        onError,
        false
    )
}