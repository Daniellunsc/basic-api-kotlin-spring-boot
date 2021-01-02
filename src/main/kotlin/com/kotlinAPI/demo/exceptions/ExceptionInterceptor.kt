package com.kotlinAPI.demo.exceptions

import org.omg.CORBA.Object
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionInterceptor: ResponseEntityExceptionHandler() {

    @ExceptionHandler(CustomException::class)
    fun handleAllExceptions(ex: CustomException): ResponseEntity<Any?>? {
        val exceptionResponse = CustomExceptionSchema(ex.message, ex.details, ex.hint)
        return ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}