package com.tutorials.service;

import com.tutorials.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
    public CategoryDto createCategory(CategoryDto categoryDto);

    //update
    public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //get
    public CategoryDto getCategory(Integer categoryId);

    //get all
    public List<CategoryDto> getAllCategory();

    //delete
    public String deleteCategory(Integer categoryId);




}
