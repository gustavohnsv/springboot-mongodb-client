package com.gustavohnsv.clients.exception;

import com.gustavohnsv.clients.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(TooFewArgumentsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Message> handleTooFewArgumentsException(TooFewArgumentsException e) {
        return new ResponseEntity<>(new Message("few arguments", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WrongArgumentsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Message> handleWrongArgumentsException(WrongArgumentsException e) {
        return new ResponseEntity<>(new Message("wrong arguments", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Message> handleResourceNotFound(ResourceNotFoundException e) {
        return new ResponseEntity<>(new Message("not found", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Message> handleAlreadyExistsException(ResourceAlreadyExistsException e) {
        return new ResponseEntity<>(new Message("conflict", e.getMessage()), HttpStatus.CONFLICT);
    }

}









