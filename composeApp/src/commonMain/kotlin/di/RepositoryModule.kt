package di

import data.repositories.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { UserRepository() }
}