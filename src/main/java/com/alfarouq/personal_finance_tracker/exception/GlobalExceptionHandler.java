package com.alfarouq.personal_finance_tracker.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
