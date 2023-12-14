package com.ratting.Ratting.Repo;

import com.ratting.Ratting.entity.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepo extends MongoRepository<Rating,String> {
    List<Rating> findByUserId(String userId);
    List<Rating>findByHotelId(String hotelId);

}
