package com.HotelService.controller;

import com.HotelService.Entity.Hotel;
import com.HotelService.payload.UserForRef;
import com.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/hotel")
@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/")
    public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel){
       Hotel hotel1=  this.hotelService.createHotel(hotel);
       return new ResponseEntity<>(hotel1, HttpStatus.CREATED);

    }
    @GetMapping("/{uid}")
    public ResponseEntity<Hotel> getSingleHotel(@PathVariable String uid){
       Hotel hotel=this.hotelService.getSingleHotel(uid);
       return  new ResponseEntity<>(hotel,HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>>getAll(){
        List<Hotel> list=this.hotelService.getAll();
        return new ResponseEntity<List<Hotel>>(list,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{hid}")
    public ResponseEntity<UserForRef>deleteHotel(@PathVariable String hid){
        this.hotelService.deleteHotel(hid);
        UserForRef ufr=new UserForRef("hotel deleted",true);
        return new ResponseEntity<>(ufr,HttpStatus.OK);
        }
    }


