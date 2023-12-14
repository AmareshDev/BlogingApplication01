package com.bloggingapp.BloggingApp.service;

import com.bloggingapp.BloggingApp.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CategoryService {

  public  CategoryDto createCategory(CategoryDto categoryDto);
  public  CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId);
  public void deleteCategory(Integer categoryId);
  public CategoryDto getSingleCategory(Integer categoryId);
  List< CategoryDto> getAllCategory();



}
