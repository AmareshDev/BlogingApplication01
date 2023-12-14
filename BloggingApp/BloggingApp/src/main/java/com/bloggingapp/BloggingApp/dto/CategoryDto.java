package com.bloggingapp.BloggingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    @NotBlank
    @Size(min=4,message="min size of category title is 4")
    private String categoryTitle;
    @NotBlank
    @Size(max=10,message="min size of category desc is 10")
    private String categoryDescription;
}
