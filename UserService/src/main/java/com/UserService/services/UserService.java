package com.UserService.services;

import com.UserService.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserService {
    User saveUser(User user);
    List<User>getAllUser();


    User getSingleUser(String uid);
}
