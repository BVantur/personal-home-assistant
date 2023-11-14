import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.ScaleTransition
import view.screens.login.LoginScreen

//@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
//    startKoin {
//        modules(appModule())
//    }
    Navigator(LoginScreen) {
        ScaleTransition(it)
    }
//    LoginScreen()
//    PHATheme {
//        var greetingText by remember { mutableStateOf(GREETING) }
//        var showImage by remember { mutableStateOf(false) }
//
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = {
//                greetingText = "Compose on ${getPlatformName()}: $GREETING"
//                showImage = !showImage
//            }) {
//                Text(greetingText)
//            }
//            AnimatedVisibility(showImage) {
//                Image(
//                    painterResource("compose-multiplatform.xml"),
//                    null
//                )
//            }
//        }
//    }
}