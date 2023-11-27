package domain.errors

sealed class LoginErrors(private val throwable: Throwable? = null): Throwable(throwable?.message, throwable?.cause) {
    data class InvalidCredentials(val error: Throwable): LoginErrors(error)
    data class Unknown(val error: Throwable): LoginErrors(error)
}