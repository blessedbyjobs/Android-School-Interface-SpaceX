package com.example.android_school_spacex.network

/**
 * Сущность, отвечающая за презентацию текущего состояния загрузки
 */
sealed class Request<T> {
    class Loading<T> : Request<T>()
    data class Success<T>(internal val data: T) : Request<T>()
    data class Error<T>(internal val error: Throwable) : Request<T>()
}