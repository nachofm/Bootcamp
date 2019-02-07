package com.globant.webProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException badRequestException) {
        return new ResponseEntity(new ResponseErrorStatus(
                badRequestException.getCode(),
                badRequestException.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
