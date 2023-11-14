package di

import cafe.adriel.voyager.navigator.Navigator
import org.koin.dsl.module
import view.screens.login.LoginViewModel

val viewModelModule = module {
    factory { (navigator: Navigator) ->
        LoginViewModel(navigator, get(), get())
    }
}