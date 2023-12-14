package com.bloggingapp.BloggingApp.controller;

import com.bloggingapp.BloggingApp.payloads.JwtRequest;
import com.bloggingapp.BloggingApp.payloads.JwtResponse;
import com.bloggingapp.BloggingApp.service.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.bloggingapp.BloggingApp.security.JwtHelper;

@RequestMapping("/aars")
@RestController
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private CustomUserDetailsServiceImpl userDetailsService;
    @PostMapping("/generate-token")
    public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest request) throws Exception {
        this.authenticate(request.getName(),request.getPassword()); //this line call the authenticate method of this class authenticate this ui and pd
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getName());
        System.out.println("USER DETAILS:  " + userDetails.getUsername());
        String token= this.jwtHelper.generateToken(userDetails);
        System.out.println("token: " + token);
          //set response
        JwtResponse response=new JwtResponse();
        response.setToken(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    private void authenticate(String username,String password) throws Exception {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);

        try {
            this.authenticationManager.authenticate(authenticationToken);   //authenticationManager is use to authenticate the username and passward   this class use spring secuity internaly

        }catch(BadCredentialsException c){
            System.out.println("invalid details !!");
            throw new Exception("invalid username and password"+ c.getMessage());
        }
    }


}
