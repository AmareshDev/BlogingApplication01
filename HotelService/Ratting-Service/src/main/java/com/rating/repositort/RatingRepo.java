package com.rating.repositort;

import com.rating.entitys.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface RatingRepo extends MongoRepository<Rating,String> {

    List<Rating> findByUserId(String userId);
    List<Rating>findByHotelId(String hotelId);



}
