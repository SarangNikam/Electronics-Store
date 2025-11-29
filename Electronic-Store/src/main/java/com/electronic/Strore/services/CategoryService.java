package com.electronic.Strore.services;

import com.electronic.Strore.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDto create(CategoryDto categoryDto);

    //update
    CategoryDto update(CategoryDto categoryDto,String categoryId);

    //delete
    void delete(String categoryId);

    //get all
    List<CategoryDto> getAllCategoy();

    // get single
    CategoryDto getById(CategoryDto categoryDto,String categoryId);
}
