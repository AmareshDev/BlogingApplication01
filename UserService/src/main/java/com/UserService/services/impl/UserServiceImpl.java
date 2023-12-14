package com.UserService.services.impl;

import com.UserService.entities.Rating;
import com.UserService.entities.User;

import com.UserService.exceptions.ResourceNotFoundException;
import com.UserService.repository.UserRepository;
import com.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component


public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepo;
    @Autowired
    private RestTemplate restTemplate;
    private Logger logger= LoggerFactory.getLogger(UserService.class);

    @Override
    public User saveUser(User user) {
        String userid= UUID.randomUUID().toString();
        user.setUserId(userid);

        User user1=userRepo.save(user);
        return user1;
    }

    @Override
    public List<User> getAllUser() {
        //can implement here restTamplet
        return userRepo.findAll();
    }


    public User getSingleUser( String uid){
       User user= this.userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException());
       //http://localhost:9999/ratings/byUser/0ef2a26f-f048-4e15-a35a-f64902d3286b
       ArrayList<Rating> ratingobject=restTemplate.getForObject("http://localhost:9999/ratings/byUser/"+user.getUserId(), ArrayList.class);
       logger.info("{}",ratingobject);


        user.setRatings(ratingobject);
       return user;
    }

}