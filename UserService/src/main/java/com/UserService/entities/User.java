package com.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
@Table(name="micro_userdbm")

public class User {
    @Column(name="ID")
    @Id

    private String userId;
    @Column(name="NAME" ,length=20)
    private String name;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ABOUT")
    private String about;
    @Transient
    private List<Rating> ratings=new ArrayList<>();

}
