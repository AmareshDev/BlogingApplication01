package com.ratting.Ratting.Exception;

import com.ratting.Ratting.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeler  {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex){
       String message=  ex.getMessage();
       return new ResponseEntity<ApiResponse>(new ApiResponse(message,true), HttpStatus.NOT_FOUND);
    }
}
