package com.UserService.repository;

import com.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository  extends JpaRepository<User,String> {
}
