package com.HotelService.service.impl;

import com.HotelService.Entity.Hotel;
import com.HotelService.exception.ResourceNotFoundException;
import com.HotelService.repo.HotelRepo;
import com.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String id= UUID.randomUUID().toString();
        hotel.setId(id);
         Hotel hotel1=this.hotelRepo.save(hotel);

        return hotel1;
    }

    @Override
    public Hotel getSingleHotel(String uid) {
        Hotel hotel1= this.hotelRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("not found"));

        return hotel1;
    }

   @Override
    public List<Hotel> getAll() {
        return this.hotelRepo.findAll();

    }

    @Override
    public void deleteHotel(String hid) {
       Hotel hotel= this.hotelRepo.findById( hid).orElseThrow(()->new ResourceNotFoundException("not found"));
       this.hotelRepo.delete(hotel);

    }
}
