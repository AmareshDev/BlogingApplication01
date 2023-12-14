package com.bloggingapp.BloggingApp.service;

import com.bloggingapp.BloggingApp.dto.CommentDto;
import org.springframework.stereotype.Component;

@Component
public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer postId);
    void deleteComment(Integer commentId);
}
