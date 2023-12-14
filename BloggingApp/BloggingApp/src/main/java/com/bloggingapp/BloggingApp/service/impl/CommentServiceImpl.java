package com.bloggingapp.BloggingApp.service.impl;

import com.bloggingapp.BloggingApp.dto.CommentDto;
import com.bloggingapp.BloggingApp.repo.CommentRepo;
import com.bloggingapp.BloggingApp.repo.PostRepo;
import com.bloggingapp.BloggingApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        return null;
    }

    @Override
    public void deleteComment(Integer commentId) {

    }
}
