package domain.usecase

import data.models.ResourceResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

interface LoginWithGoogleUseCase {
    suspend operator fun invoke(dispatcher: CoroutineDispatcher): Flow<ResourceResult<Unit>>
}