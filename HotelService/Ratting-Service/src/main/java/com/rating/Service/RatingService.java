package com.rating.Service;

import com.rating.entitys.Rating;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    //create

Rating crete (Rating rating);

    //get all rating
    List<Rating> getRating();

    //get all by userId
    List<Rating>getRatingByUserId(String userId);

    //get all by hotel
   List<Rating> getRatingByHotelId(String userId);
}
