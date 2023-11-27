package data.usecase

import data.models.TextData
import domain.usecase.EmailValidationUseCase
import sp.bvantur.assistant.SharedRes

class EmailValidationUseCaseImpl : EmailValidationUseCase {
    override fun invoke(email: String): TextData? {
        val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()

        if (email.isBlank() || !emailRegex.matches(email)) {
            return TextData.StringRes(SharedRes.strings.invalid_email)
        }

        return null
    }
}