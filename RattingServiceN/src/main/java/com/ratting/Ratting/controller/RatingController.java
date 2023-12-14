package com.ratting.Ratting.controller;

import com.ratting.Ratting.entity.Rating;
import com.ratting.Ratting.payload.ApiResponse;
import com.ratting.Ratting.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/")
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        Rating rating1=  this.ratingService.create(rating);
        return new  ResponseEntity(rating1, HttpStatus.CREATED) ;
    }
    @GetMapping("/rating")
    public ResponseEntity<List<Rating>>getRating(){
        List<Rating> ratings=this.ratingService.getRating();

        return  new ResponseEntity<>(ratings,HttpStatus.OK);
    }
    @GetMapping("/byUser/{uid}")
    public ResponseEntity<List<Rating>>getRatingByUserId(@PathVariable String uid){
        List<Rating>ratings=this.ratingService.getRatingByUserId(uid);
        return  new ResponseEntity<>(ratings,HttpStatus.OK);

    }
    @GetMapping("/byHotel/{hid}")
    public ResponseEntity<List<Rating>>getRatingByHotelId(@PathVariable String hid){
        List<Rating>ratings=this.ratingService.getRatingByHotelId(hid);
        return  ResponseEntity.status(HttpStatus.OK).body(ratings);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<ApiResponse>deleteHotel(@PathVariable  String id){
        this.ratingService.deleteHotel(id);

        return new ResponseEntity<ApiResponse>(new ApiResponse("deleted",true),HttpStatus.OK);
    }

}
