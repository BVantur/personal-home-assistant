package di

import org.koin.core.context.startKoin

fun appModule() = listOf(
    viewModelModule,
    repositoryModule,
    useCaseModule,
    utilsModule
)

fun initKoin() {
    startKoin {
        modules(appModule())
    }
}