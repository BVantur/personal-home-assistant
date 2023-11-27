package data.usecase

import data.models.TextData
import domain.usecase.EmailValidationUseCase
import domain.usecase.PasswordValidationUseCase
import sp.bvantur.assistant.SharedRes

class PasswordValidationUseCaseImpl : PasswordValidationUseCase {
    override fun invoke(password: String): TextData? {
        if (password.isNullOrEmpty()) {
            return TextData.StringRes(SharedRes.strings.empty_password)
        }

        if (password.length < 6) {
            return TextData.StringRes(SharedRes.strings.un_sufficient_password_length)
        }

        return null
    }
}