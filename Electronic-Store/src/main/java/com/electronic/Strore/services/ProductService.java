package com.electronic.Strore.services;

import com.electronic.Strore.dto.ProductDto;

import java.awt.*;
import java.util.List;

public interface ProductService {

    //create
    ProductDto create(ProductDto productDto);
    //update
    ProductDto update(ProductDto productDto,String productId);


    //delete
    void delete(String productID);

    //get all
    List<ProductDto> getAllProduct();

    //get by price
    ProductDto getByPrice(double price);

    //search
    List<ProductDto> search(String keyword);

    //get by discount
    List<ProductDto> getByDiscount(double discount);

    //create  product with category
    ProductDto createWithCategory(ProductDto productDto,String categoryId);


}
