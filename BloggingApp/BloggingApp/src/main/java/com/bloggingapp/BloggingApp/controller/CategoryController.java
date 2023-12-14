package com.bloggingapp.BloggingApp.controller;

import com.bloggingapp.BloggingApp.dto.CategoryDto;
import com.bloggingapp.BloggingApp.payloads.ApiResponse;
import com.bloggingapp.BloggingApp.service.CategoryService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
@PostMapping("/")
    public ResponseEntity<CategoryDto>createCategory(@Valid @RequestBody CategoryDto categoryDto){
    System.out.println(categoryDto);
    CategoryDto createdCategory= this.categoryService.createCategory (categoryDto);
    return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
}
@PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto>updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable("categoryId")Integer cId){
    CategoryDto  updated =this.categoryService.UpdateCategory(categoryDto,cId);
    return new ResponseEntity<CategoryDto>(updated,HttpStatus.OK);
}
@DeleteMapping("/{categoryId}")
public ResponseEntity<ApiResponse>deleteCategory(@PathVariable Integer categoryId){
    this.categoryService.deleteCategory(categoryId);
    return new  ResponseEntity<ApiResponse>(new ApiResponse("category  deleted successfully",true),HttpStatus.OK);

}
@GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto>getSingleCategory(@PathVariable Integer categoryId){
    CategoryDto founded= this.categoryService.getSingleCategory(categoryId);
     return  new ResponseEntity<CategoryDto>(founded,HttpStatus.OK);
}
@GetMapping("/")
    public ResponseEntity <List<CategoryDto>>getAllCategory(){
     List<CategoryDto>categoryDtoList=this.categoryService.getAllCategory();
     return new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
}

}
