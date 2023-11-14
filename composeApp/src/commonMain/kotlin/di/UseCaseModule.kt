package di

import data.usecase.LoginWithGoogleUseCaseImpl
import domain.usecase.LoginWithGoogleUseCase
import org.koin.dsl.bind
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginWithGoogleUseCaseImpl() } bind LoginWithGoogleUseCase::class
}