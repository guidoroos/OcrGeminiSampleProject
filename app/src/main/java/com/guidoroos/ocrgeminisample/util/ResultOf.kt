package com.guidoroos.ocrgeminisample.util

sealed class ResultOf<out T> {
    data class Success<T>(val data: T) : ResultOf<T>()

    data class Error(
        val errorResourceId: Int,
        val customErrorMessage: String? = null
    ) : ResultOf<Nothing>()
    data object Loading : ResultOf<Nothing>()

    data object None : ResultOf<Nothing>()
}