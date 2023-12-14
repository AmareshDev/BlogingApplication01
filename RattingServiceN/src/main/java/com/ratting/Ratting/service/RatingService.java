package com.ratting.Ratting.service;

import com.ratting.Ratting.entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    //create

    Rating create (Rating rating);

    //get all rating
    List<Rating> getRating();

    //get all by userId
    List<Rating>getRatingByUserId(String userId);

    //get all by hotel
    List<Rating> getRatingByHotelId(String userId);

    void deleteHotel(String id);
}
