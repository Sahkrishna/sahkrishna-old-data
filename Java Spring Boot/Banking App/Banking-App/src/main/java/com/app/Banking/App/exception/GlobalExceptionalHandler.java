package com.app.Banking.App.exception;

import com.app.Banking.App.payloads.ApiMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

        String message=ex.getMessage();

        ApiMessage apiMessage = new ApiMessage(message,false);

        return new ResponseEntity<ApiMessage>(apiMessage, HttpStatus.NOT_FOUND);
    }
}
