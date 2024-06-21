package com.gustavohnsv.clients.exception;

public class TooFewArgumentsException extends RuntimeException {
    public TooFewArgumentsException(String message) {
        super(message);
    }
}
