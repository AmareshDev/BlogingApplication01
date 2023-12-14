package com.HotelService.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;



public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String notFound){
        super(notFound);
    }
    public ResourceNotFoundException(){   ///why this is use

    }


}
