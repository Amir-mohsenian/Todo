package com.photo.mahsa.model

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error<T>(val message: String? = "") : Result<T>
}

val Result<*>.succeeded
    get() = this is Result.Success && data != null

fun Result<*>.toString(): String {
    return when (this) {
        is Result.Success -> {
            "success and data is ${this.data}"
        }

        is Result.Error -> {
            "error and message is ${this.message}"
        }
    }
}

fun Result<*>.toUnit(): Result<Unit> {
    return if (this.succeeded) Result.Success(Unit) else Result.Error((this as Result.Error).message)
}
