package di

import org.koin.dsl.bind
import org.koin.dsl.module
import utils.DispatcherProvider
import utils.DispatcherProviderImpl

val utilsModule = module {
    single { DispatcherProviderImpl() } bind DispatcherProvider::class
}