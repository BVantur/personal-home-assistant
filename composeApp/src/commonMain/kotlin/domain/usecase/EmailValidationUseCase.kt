package domain.usecase

import data.models.TextData

interface EmailValidationUseCase {
    operator fun invoke(email: String): TextData?
}