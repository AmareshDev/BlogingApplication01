package com.bloggingapp.BloggingApp.service.impl;

import com.bloggingapp.BloggingApp.entity.User;
import com.bloggingapp.BloggingApp.exception.ResourceNotFoundException;
import com.bloggingapp.BloggingApp.repo.UserRepo;
import com.bloggingapp.BloggingApp.dto.UserDto;
import com.bloggingapp.BloggingApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
     private ModelMapper modelMapper;
      @Autowired
      private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {

        String password = userDto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        userDto.setPassword(encodedPassword);

       User user = dtoToEntity(userDto);

       User createduser = userRepo.save(user);
        return entityToDto(createduser);
    }

    @Override
    public UserDto updateUser(UserDto UserDto ,Integer uid) {
        User foundeduser=this.userRepo.findById(uid).orElseThrow(()->new ResourceNotFoundException("User","Id","userId"));
        foundeduser.setName(UserDto.getName());
        foundeduser.setEmail(UserDto.getEmail()) ;
        foundeduser.setPassword(UserDto.getPassword());
        foundeduser.setAbout(UserDto.getAbout());

        User updeteduser =this.userRepo.save(foundeduser);

        UserDto udto=entityToDto(updeteduser);
        return udto;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id","userId"));
        this.userRepo.delete(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> allusers=this.userRepo.findAll();
       List<UserDto>userDto=allusers.stream().map(user-> this.entityToDto(user)).collect(Collectors.toList());
        return userDto ;
    }


    public UserDto getUserById(Integer userId) {
        User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id","UserId"));
        return this.entityToDto(user);
    }





    private UserDto entityToDto(User user2) {
        return modelMapper.map(user2,UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {
        return modelMapper.map(userDto,User.class);
    }

}
