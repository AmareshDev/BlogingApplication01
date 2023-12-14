package com.ratting.Ratting.service.impl;

import com.ratting.Ratting.Exception.ResourceNotFoundException;
import com.ratting.Ratting.Repo.RatingRepo;
import com.ratting.Ratting.entity.Rating;
import com.ratting.Ratting.payload.ApiResponse;
import com.ratting.Ratting.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepo ratingRepo;
    @Override
    public Rating create(Rating rating) {
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

    @Override
    public void deleteHotel(String id) {
        Rating rating1= this.ratingRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
        this.ratingRepo.delete(rating1);

    }
}
