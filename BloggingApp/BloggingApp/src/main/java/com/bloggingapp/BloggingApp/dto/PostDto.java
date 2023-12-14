package com.bloggingapp.BloggingApp.dto;

import com.bloggingapp.BloggingApp.entity.Category;
import com.bloggingapp.BloggingApp.entity.Comment;
import com.bloggingapp.BloggingApp.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
public class PostDto {
    private Integer postId;
private String title;
private String content;
private String  imageName;
private Date adddate;
private CategoryDto category;
private UserDto user;
private Set<Comment> comments=new HashSet<>();


}
