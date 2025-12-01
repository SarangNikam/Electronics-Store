package com.electronic.Strore.services.impl;

import com.electronic.Strore.dto.AddItemToCartRequest;
import com.electronic.Strore.dto.CartDto;
import com.electronic.Strore.entities.Product;
import com.electronic.Strore.entities.User;
import com.electronic.Strore.exception.ResourceNotFoundException;
import com.electronic.Strore.repositories.CartRepository;
import com.electronic.Strore.repositories.ProductRepository;
import com.electronic.Strore.repositories.UserRepository;
import com.electronic.Strore.services.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CartServiceimpl implements CartService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CartDto addItemToCart(int userId, AddItemToCartRequest request) {
        int quantity=request.getQuantity();
        String productId=request.getProductId();
        //fetch the product
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Not found with this id"));
        //fetch user from db
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with this id"));
    }

    @Override
    public void deleteItem(int cartItem, int userId) {

    }

    @Override
    public void clearCart(int userId) {

    }
}
