package data.usecase

import data.models.ResourceResult
import domain.usecase.LoginWithGoogleUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LoginWithGoogleUseCaseImpl : LoginWithGoogleUseCase {
    override suspend fun invoke(dispatcher: CoroutineDispatcher): Flow<ResourceResult<Unit>> {
        return flow {
            emit(ResourceResult.Loading)
//            Firebase.auth. // check if is already signed in if null is not

//            Firebase.auth.signInWithCredential()
//            AuthCredential()


//            GoogleAuthProvider.credential()
//            Firebase.auth(Firebase.app("")).sin


            delay(5000)
            emit(ResourceResult.Success(Unit))
        }.catch {
            emit(ResourceResult.Error(it))
        }.flowOn(dispatcher)
    }
}