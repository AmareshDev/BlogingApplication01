package com.bloggingapp.BloggingApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDto {
    private Integer userId;
    @NotEmpty     //@NotEmpty -means data should not be empty and null
    @Size(min=4,message=" Username must be min of 4 character!! ")
    private String name;

    @Email(message = "Email address is not valid!!")                //@Email -means email should be correct
    private String email;

    @NotEmpty
    @Size(max=10,min=3,message="password must be min of 3char and max10 chars!!")
    private String password;

    @NotEmpty
    private String about;
}
