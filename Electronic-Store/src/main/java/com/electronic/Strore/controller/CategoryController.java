package com.electronic.Strore.controller;

import com.electronic.Strore.dto.CategoryDto;
import com.electronic.Strore.dto.UserDto;
import com.electronic.Strore.services.CategoryService;
import com.electronic.Strore.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    public CategoryService categoryService;

    //create
    @PostMapping
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto category = categoryService.create(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> update(
            @Valid @PathVariable ("categoryId") String categoryId,
            @RequestBody CategoryDto categoryDto
    ){
        CategoryDto updateCategory = categoryService.update(categoryDto, categoryId);
        return new ResponseEntity<>(updateCategory,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> delete(@PathVariable ("categoryId") String categoryId){
        categoryService.delete(categoryId);
        return new ResponseEntity<>("User deleted success fully!!",HttpStatus.OK);

    }
    //get all Category
    @GetMapping
     public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> allCategory = categoryService.getAllCategory();
        return new ResponseEntity<>(allCategory,HttpStatus.OK);
    }

    //get Category by id
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable String categoryId){
        CategoryDto categoryDto = categoryService.getById(categoryId);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }


}
