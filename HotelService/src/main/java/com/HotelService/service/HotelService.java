package com.HotelService.service;

import com.HotelService.Entity.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel getSingleHotel(String uid);

    List<Hotel> getAll();


    void deleteHotel(String hid);
}
