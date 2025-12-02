package com.electronic.Strore.controller;

import com.electronic.Strore.dto.AddItemToCartRequest;
import com.electronic.Strore.dto.ApiResponseMessage;
import com.electronic.Strore.dto.CartDto;
import com.electronic.Strore.services.CartService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    //add item to cart
    @PostMapping("/{userId}")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable int userId, @RequestBody AddItemToCartRequest request) {
        CartDto cartDto = cartService.addItemToCart(userId, request);
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/items/{itemId}")
    public ResponseEntity<ApiResponseMessage> removeItemFromCart(@PathVariable int userId, @PathVariable int itemId) {
        cartService.deleteItem(userId, itemId);
        ApiResponseMessage response = ApiResponseMessage.builder()
                .message("item is removed")
                .success(true)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponseMessage> clearCart(@PathVariable int userId) {
        cartService.clearCart(userId);
        ApiResponseMessage response = ApiResponseMessage.builder()
                .message("Not cart is blank")
                .success(true)
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);


    }
    @GetMapping("/{userId}")
    public ResponseEntity<CartDto> getCart(@PathVariable int userId){
        CartDto cartDto = cartService.getCartByUser(userId);
        return new ResponseEntity<>(cartDto,HttpStatus.OK);
    }

}
