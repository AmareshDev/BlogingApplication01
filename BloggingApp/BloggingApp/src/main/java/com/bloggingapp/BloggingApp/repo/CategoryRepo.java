package com.bloggingapp.BloggingApp.repo;

import com.bloggingapp.BloggingApp.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CategoryRepo extends JpaRepository<Category,Integer> {





}
