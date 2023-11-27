package di

import data.usecase.EmailValidationUseCaseImpl
import data.usecase.LoginWithGoogleUseCaseImpl
import data.usecase.PasswordValidationUseCaseImpl
import domain.usecase.EmailValidationUseCase
import domain.usecase.LoginWithGoogleUseCase
import domain.usecase.PasswordValidationUseCase
import org.koin.dsl.bind
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginWithGoogleUseCaseImpl() } bind LoginWithGoogleUseCase::class
    single { EmailValidationUseCaseImpl() } bind EmailValidationUseCase::class
    single { PasswordValidationUseCaseImpl() } bind PasswordValidationUseCase::class
}