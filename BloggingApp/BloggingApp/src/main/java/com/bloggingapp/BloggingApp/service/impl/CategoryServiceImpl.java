package com.bloggingapp.BloggingApp.service.impl;

import com.bloggingapp.BloggingApp.dto.CategoryDto;
import com.bloggingapp.BloggingApp.entity.Category;
import com.bloggingapp.BloggingApp.exception.ResourceNotFoundException;
import com.bloggingapp.BloggingApp.repo.CategoryRepo;
import com.bloggingapp.BloggingApp.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
      Category category=  this.modelMapper.map(categoryDto, Category.class);
       Category savedCategory =this.categoryRepo.save(category);
      return modelMapper.map(savedCategory,CategoryDto.class);
    }
    @Override
    public CategoryDto UpdateCategory(CategoryDto categoryDto, Integer categoryId) {
       Category category= this.categoryRepo.findById(categoryId)
               .orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId+""));
      category.setCategoryTitle( categoryDto.getCategoryTitle());
      category.setCategoryDescription(categoryDto.getCategoryTitle());
       Category updatedCategory= this.categoryRepo.save(category);
          CategoryDto rcat=this.modelMapper.map(updatedCategory,CategoryDto.class);
          return rcat;
    }
    @Override
    public void deleteCategory(Integer categoryId) {
    Category category=this.categoryRepo.findById(categoryId)
            .orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryId+""));
    this.categoryRepo.delete(category);
    }
    @Override
    public CategoryDto getSingleCategory(Integer categoryId) {
         Category category=this.categoryRepo.findById(categoryId)
                 .orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId+""));
       CategoryDto gotUser= this.modelMapper.map(category,CategoryDto.class);

        return gotUser;
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category>allCategory= this.categoryRepo.findAll();
       List<CategoryDto> ralldata= allCategory.stream().map(cat->this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
        return ralldata;
    }
}
