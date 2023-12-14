package com.bloggingapp.BloggingApp.service;

import com.bloggingapp.BloggingApp.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {

    public UserDto createUser(UserDto UserDto);
    public UserDto updateUser(UserDto  UserDto, Integer uid);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
