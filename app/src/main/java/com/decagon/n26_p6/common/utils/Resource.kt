package com.decagon.n26_p6.common.utils

sealed class Resource<T>() {
    class Success<T>(data: T) : Resource<T>()
    class Error<T>(message: String) : Resource<T>()
    class Loading<T>(message: String) : Resource<T>()
    class Empty<T>(message: String) : Resource<T>()
}

