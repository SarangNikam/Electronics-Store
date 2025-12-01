package com.electronic.Strore.controller;

import com.electronic.Strore.dto.ProductDto;
import com.electronic.Strore.dto.UserDto;
import com.electronic.Strore.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    //create
    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto productDto){
        ProductDto productDto1 = productService.create(productDto);
        return new ResponseEntity<>(productDto1, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> update(
            @PathVariable String productId,
            @RequestBody ProductDto productDto
    ){
        ProductDto updated = productService.update(productDto, productId);
        return new ResponseEntity<>(updated,HttpStatus.OK);
    }

    //get all
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll(){
        List<ProductDto> allProduct = productService.getAllProduct();
        return new ResponseEntity<>(allProduct,HttpStatus.OK);

    }

    //get by price
    @GetMapping("/price/{price}")
    public ResponseEntity<ProductDto> getByPrice(@PathVariable double price){
        ProductDto byPrice = productService.getByPrice(price);
        return new ResponseEntity<>(byPrice,HttpStatus.OK);
    }


    //get by discount
    @GetMapping("/discount/{discount}")
    public ResponseEntity<List<ProductDto>> getByDiscount(@PathVariable double discount){

        List<ProductDto> byDiscount = productService.getByDiscount(discount);
        return new ResponseEntity<>(byDiscount, HttpStatus.OK);
    }



    //delete
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> delete(@PathVariable String productId){
        productService.delete(productId);
        return new ResponseEntity<>("Product deleted Successfully!!",HttpStatus.OK);
    }

    //search
    @GetMapping("/search/{keyword}")
    public  List<ProductDto> getByKeyword(@PathVariable String keyword) {
        List<ProductDto> userDto = productService.search(keyword);
        return userDto;

    }
}
