package com.HotelService.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class UserForRef {
    private  String message;
    private boolean data;

    public UserForRef() {
    }

    public UserForRef(String message ,boolean data) {
        this.message = message;
        this.data=data;
    }

}
