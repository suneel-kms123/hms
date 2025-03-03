package com.hms.hms.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HmsExceptionHandler {

    @ExceptionHandler(MyResourceNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(MyResourceNotFoundException exception) {
        return new ResponseEntity<>("Error" + exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
