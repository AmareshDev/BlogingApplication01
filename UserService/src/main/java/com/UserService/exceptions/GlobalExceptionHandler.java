package com.UserService.exceptions;

import com.UserService.payload.ApiResponce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Component
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponce>handelResourceNotFoundException(ResourceNotFoundException ex){
        String message=ex.getMessage();
         ApiResponce response = ApiResponce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
         return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
