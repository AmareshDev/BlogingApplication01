package com.bloggingapp.BloggingApp.service.impl;

import com.bloggingapp.BloggingApp.entity.User;
import com.bloggingapp.BloggingApp.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
     private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {  // spring security will use this method //useing this method by username spring security can get user
        User user=this.userRepo.findByName(name);
        if(user==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("no user found");
        }
        return user;
    }
}
