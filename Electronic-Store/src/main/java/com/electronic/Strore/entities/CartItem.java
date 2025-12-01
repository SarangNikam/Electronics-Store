package com.electronic.Strore.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cartItem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;

    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;
    private int quantity;
    private int totalPrice;

    //mapped by cart
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cartId")
    private Cart cart;
}
