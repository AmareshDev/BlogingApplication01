package com.rating.Service.impl;

import com.rating.Service.RatingService;
import com.rating.entitys.Rating;
import com.rating.repositort.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RatingServiceImpl implements RatingService {
    @Autowired
    private  RatingRepo ratingRepo;
    @Override
    public Rating crete(Rating rating) {
        return  ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRating() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return this.ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return this.ratingRepo.findByHotelId (hotelId);
    }
}
