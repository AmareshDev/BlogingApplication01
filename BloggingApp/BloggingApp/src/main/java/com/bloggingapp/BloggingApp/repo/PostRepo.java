package com.bloggingapp.BloggingApp.repo;

import com.bloggingapp.BloggingApp.entity.Category;
import com.bloggingapp.BloggingApp.entity.Post;
import com.bloggingapp.BloggingApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {
    List<Post>findByUser(User user);
    List<Post>findByCategory(Category category );
    @Query("select p from Post p where p.title like :key")
    List<Post>findByTitle(@Param("key")String title);
}
