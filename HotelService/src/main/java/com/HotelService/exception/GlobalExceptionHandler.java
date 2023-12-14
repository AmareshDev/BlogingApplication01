package com.HotelService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Component
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String ,Object>> resourceNotFoundException(ResourceNotFoundException ex){
        Map<String,Object>mp =new HashMap<>();
        mp.put("message" ,ex.getMessage());
        mp.put("success",false);
        mp.put("status",HttpStatus.NOT_FOUND);
        //return new ResponseEntity<Map<String,Object>>(mp,HttpStatus.NOT_FOUND);
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(mp);
    }

}
