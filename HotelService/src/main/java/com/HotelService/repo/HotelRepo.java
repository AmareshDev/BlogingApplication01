package com.HotelService.repo;

import com.HotelService.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface HotelRepo extends JpaRepository<Hotel,String> {

}
