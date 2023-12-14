package com.bloggingapp.BloggingApp.controller;

import com.bloggingapp.BloggingApp.dto.UserDto;
import com.bloggingapp.BloggingApp.payloads.ApiResponse;
import com.bloggingapp.BloggingApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class  UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){

        UserDto userDto1 = userService.createUser(userDto);
        System.out.println(userDto1);
        return  new ResponseEntity<>(userDto1,HttpStatus.CREATED);
    }
     @PutMapping("/{userId}")
      public ResponseEntity<UserDto>updateUser(@Valid @RequestBody UserDto UserDto , @PathVariable("userId")Integer uId){
           UserDto udto =this.userService.updateUser(UserDto,uId);
           return ResponseEntity.ok(udto);
    }
    //ADMIN ONLY CAN ACCESS
    //DELETE USER
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse>deleteUser(@PathVariable("userId")Integer uid){
       this.userService.deleteUser(uid);
       return new ResponseEntity<>(new ApiResponse("User deleted",true),HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity<List<UserDto>>getAllUser(){
       List<UserDto> allusers= this.userService.getAllUsers();
        return  ResponseEntity.ok(allusers);

    }
    @GetMapping("{userId}")
    public ResponseEntity<UserDto>getUserById(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }


}

