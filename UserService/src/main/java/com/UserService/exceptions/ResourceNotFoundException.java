package com.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("not found");

    }
    public ResourceNotFoundException(String message){
        super(message);

    }
}

