package com.wepping.wepper.common.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

open class HttpException(
    override val errorCode: ErrorCode,
    message: String,
) : BaseException(errorCode, message) {

    enum class ErrorCode(val code: Int) {
        BAD_REQUEST(400),
        UNAUTHORIZED(401),
        FORBIDDEN(403),
        NOT_FOUND(404),
        CONFLICT(409),
        GONE(410),
        INTERNAL_SERVER_ERROR(500),
        SERVICE_UNAVAILABLE(503)
    }
}

@RestControllerAdvice
class HttpExceptionAdvice {

    @ExceptionHandler
    fun handleHttpException(e: HttpException): ResponseEntity<ExceptionDto> {
        val dto = ExceptionDto(e.errorCode.code, e.message, null)
        return ResponseEntity(dto, HttpStatus.valueOf(e.errorCode.code))
    }
}

class NotFoundException(message: String) : HttpException(ErrorCode.NOT_FOUND, message)
class BadRequestException(message: String) : HttpException(ErrorCode.BAD_REQUEST, message)