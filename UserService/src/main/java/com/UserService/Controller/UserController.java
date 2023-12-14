package com.UserService.Controller;


import com.UserService.entities.User;
import com.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")

public class UserController {
    @Autowired
    private UserService userService;
@PostMapping("/user12")
 public ResponseEntity<User>saveUser(@RequestBody User user){
     User saveduser =this.userService.saveUser(user);
      return new ResponseEntity<>(saveduser, HttpStatus.CREATED);
}
@GetMapping("/")
 public ResponseEntity<List<User>> getAllUser(){
   List<User> allUser= this.userService.getAllUser();
    return  ResponseEntity.ok(allUser);
}
@GetMapping("/single/{uid}")
    public ResponseEntity <User> getSingleUser(@PathVariable String uid){
     User userre=this.userService.getSingleUser(uid);
    return new ResponseEntity<User>(userre,HttpStatus.OK);
    }

}
