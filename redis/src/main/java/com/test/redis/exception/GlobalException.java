package com.test.redis.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {


    @ExceptionHandler(IdempotentException.class)
    public String idempotentException(IdempotentException exception) {
        return exception.getMessage();
    }
}
