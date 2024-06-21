package com.gustavohnsv.clients.exception;

public class WrongArgumentsException extends RuntimeException {
    public WrongArgumentsException(String message) {
        super(message);
    }
}