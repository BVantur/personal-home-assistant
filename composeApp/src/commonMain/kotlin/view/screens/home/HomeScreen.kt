package view.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import view.components.H3Text
import view.theme.PHATheme

object HomeScreen: Screen {

    @Composable
    override fun Content() {
        PHATheme {
            Scaffold(modifier = Modifier.fillMaxSize()) {
                H3Text("HOME SCREEN")
            }
        }
    }
}