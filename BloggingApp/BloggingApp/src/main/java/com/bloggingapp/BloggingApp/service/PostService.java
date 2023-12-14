package com.bloggingapp.BloggingApp.service;

import com.bloggingapp.BloggingApp.dto.PostDto;
import com.bloggingapp.BloggingApp.entity.Post;
import com.bloggingapp.BloggingApp.payloads.PostResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostService {
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
    PostDto updatePost(PostDto postDto,Integer postId);
    void deletePost(Integer postId);
    PostDto getSinglePost(Integer PostId);
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    public List<PostDto>getPostByCategory(Integer categoryId);

    List<PostDto>getPostsByUSer(Integer userId);
    List<PostDto> searchPosts(String keyword);
}
