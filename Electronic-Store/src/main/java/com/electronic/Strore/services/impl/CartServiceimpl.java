package com.electronic.Strore.services.impl;

import com.electronic.Strore.dto.AddItemToCartRequest;
import com.electronic.Strore.dto.CartDto;
import com.electronic.Strore.entities.Cart;
import com.electronic.Strore.entities.CartItem;
import com.electronic.Strore.entities.Product;
import com.electronic.Strore.entities.User;
import com.electronic.Strore.exception.BadApiRequestException;
import com.electronic.Strore.exception.ResourceNotFoundException;
import com.electronic.Strore.repositories.CartItemRepository;
import com.electronic.Strore.repositories.CartRepository;
import com.electronic.Strore.repositories.ProductRepository;
import com.electronic.Strore.repositories.UserRepository;
import com.electronic.Strore.services.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
@Service
public class    CartServiceimpl implements CartService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartDto addItemToCart(int userId, AddItemToCartRequest request) {
        int quantity=request.getQuantity();
        String productId=request.getProductId();

        if(quantity<=0){
            throw new BadApiRequestException("Requested quantity is not valid");
        }
        //fetch the product
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Not found with this id"));
        //fetch user from db
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with this id"));
        Cart cart =null;
        try {
            cart = cartRepository.findByUser(user).get();
        }catch (NoSuchElementException e){
            cart=new Cart();
        }

        //if cart item already available then update

        //perform cart opration
        AtomicReference<Boolean> updated=new AtomicReference<>(false);
        List<CartItem> items = cart.getItems();
        items.stream()
                .map(item->{
                    if(item.getProduct().getProductId().equals(productId)){
                        //item already present
                        item.setQuantity(item.getQuantity() + quantity);

                        item.setTotalPrice((int) (quantity*product.getPrice()));
                        updated.set(true);
                    }
                    return item;
                }).collect(Collectors.toList());

        cart.setItems(items);

        //create items
        if(!updated.get()){
            CartItem cartItem = CartItem.builder()
                    .quantity(quantity)
                    .totalPrice((int) (quantity * product.getPrice()))
                    .cart(cart)
                    .product(product)
                    .build();
            cart.getItems().add(cartItem);
        }
        cart.setUser(user);
        Cart updatedCart = cartRepository.save(cart);
        CartDto cartDto = mapper.map(updatedCart, CartDto.class);
        return  cartDto;

    }

    @Override
    public void deleteItem(int cartItem, int userId) {
        CartItem cartItem1 = cartItemRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("cart not found with ths id"));
        cartItemRepository.delete(cartItem1);

    }

    @Override
    public void clearCart(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with this id"));
        Cart cart = cartRepository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("cart with given user not found"));
        cart.getItems().clear();
        cartRepository.save(cart);

    }

    @Override
    public CartDto getCartByUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with this id"));
        Cart cart = cartRepository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("cart with given user not found"));
        CartDto cartDto = mapper.map(cart, CartDto.class);
        return cartDto;
    }
}
