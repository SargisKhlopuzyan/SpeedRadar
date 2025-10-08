package com.sargis.khlopuzyan.domain.util

import com.sargis.khlopuzyan.domain.error.BaseError

sealed class Result<T>(val data: T? = null, val errorCode: BaseError? = null) {
    class Success<T>(data: T?) : Result<T>(data)
    class Error<T>(errorCode: BaseError, data: T? = null) : Result<T>(data, errorCode)
}