package com.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    private  String ratingId;
    private String userId;
    private String hotelId;
    private  int rating;
    private String feedback;

    //private Hotel hotel;

}
