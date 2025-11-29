package com.electronic.Strore.services.impl;

import com.electronic.Strore.dto.CategoryDto;
import com.electronic.Strore.entities.Category;
import com.electronic.Strore.repositories.CategoryRepository;
import com.electronic.Strore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private CategoryService categoryService;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {

        return null;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {
        return null;
    }

    @Override
    public void delete(String categoryId) {

    }

    @Override
    public List<CategoryDto> getAllCategoy() {
        return List.of();
    }

    @Override
    public CategoryDto getById(CategoryDto categoryDto, String categoryId) {
        return null;
    }
}
