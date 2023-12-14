package com.bloggingapp.BloggingApp.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer  postId;
    @Column(name="postTitle",length=1000,nullable = false)
    private String title;
    private  String content;
    private String imageName;
    private Date addDate;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy="post",cascade=CascadeType.ALL)
    private Set<Comment> comments=new  HashSet<>();

}
