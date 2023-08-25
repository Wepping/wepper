package com.wepping.wepper.common.exception

open class BaseException(
    open val errorCode: Any,
    override val message: String
) : RuntimeException()


class ExceptionDto(
    val statusCode: Int,
    val message: String,
    val errorCode: Any?
)