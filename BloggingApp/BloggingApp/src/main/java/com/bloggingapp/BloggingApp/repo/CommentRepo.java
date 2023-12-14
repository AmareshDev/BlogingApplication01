package com.bloggingapp.BloggingApp.repo;

import com.bloggingapp.BloggingApp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {

}
