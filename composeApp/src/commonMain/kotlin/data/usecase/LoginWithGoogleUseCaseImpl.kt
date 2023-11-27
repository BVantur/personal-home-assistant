package data.usecase

import data.models.ResourceResult
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseAuthInvalidCredentialsException
import dev.gitlive.firebase.auth.auth
import domain.errors.LoginErrors
import domain.usecase.LoginWithGoogleUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LoginWithGoogleUseCaseImpl : LoginWithGoogleUseCase {
    override suspend fun invoke(dispatcher: CoroutineDispatcher, email: String, password: String): Flow<ResourceResult<Unit>> {
        return flow {
            emit(ResourceResult.Loading)
            try {
                val authResult = Firebase.auth.signInWithEmailAndPassword(email, password)
                emit(ResourceResult.Success(Unit))
            } catch (exc: Throwable) {
                when (exc) {
                    is FirebaseAuthInvalidCredentialsException -> {
                        emit(ResourceResult.Error(LoginErrors.InvalidCredentials(exc)))
                    }

                    else -> {
                        emit(ResourceResult.Error(exc))
                    }
                }
                emit(ResourceResult.Error(exc))
            }
        }.catch {
            emit(ResourceResult.Error(it))
        }.flowOn(dispatcher)
    }
}