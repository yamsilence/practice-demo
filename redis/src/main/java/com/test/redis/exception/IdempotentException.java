package com.test.redis.exception;

public class IdempotentException extends Exception{
    public IdempotentException(String message) {
        super(message);
    }
}
