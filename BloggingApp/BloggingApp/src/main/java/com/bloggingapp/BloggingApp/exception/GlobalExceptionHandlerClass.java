package com.bloggingapp.BloggingApp.exception;

import com.bloggingapp.BloggingApp.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@Component
@RestControllerAdvice
public class GlobalExceptionHandlerClass {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exa) {
        String message = exa.getMessage();
        ApiResponse ar = new ApiResponse(message, false);
        return new ResponseEntity<>(ar, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException exx) {
        Map<String, String >resp=new HashMap<>();

      exx.getBindingResult().getAllErrors().forEach((error)->{
          String fieldName= ((FieldError) error).getField();
          String message=error.getDefaultMessage();
          resp.put(fieldName,message);
      }) ;
return new ResponseEntity<Map<String ,String>>(resp,HttpStatus.BAD_REQUEST);







    }
}