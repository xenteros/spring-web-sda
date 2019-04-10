package com.github.xenteros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<Void> handleResourceNotFoundException(ResourceNotFoundException e) {
        System.out.println("Exception occurred");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
