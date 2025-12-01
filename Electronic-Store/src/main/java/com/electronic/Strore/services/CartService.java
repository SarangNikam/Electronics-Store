package com.electronic.Strore.services;

import com.electronic.Strore.dto.AddItemToCartRequest;
import com.electronic.Strore.dto.CartDto;

public interface CartService {
    //add items to cart
    //if cart is not available then we create cart and add items
    //if cart available then add items

    CartDto addItemToCart(int userId, AddItemToCartRequest request);

    //remove item from cart
    void deleteItem(int cartItem,int userId);

    //clear cart
    void clearCart(int userId);
}
