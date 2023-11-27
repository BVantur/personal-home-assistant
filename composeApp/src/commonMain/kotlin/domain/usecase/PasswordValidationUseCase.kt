package domain.usecase

import data.models.TextData

interface PasswordValidationUseCase {
    operator fun invoke(password: String): TextData?
}