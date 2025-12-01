package com.electronic.Strore.dto;

import com.electronic.Strore.entities.Cart;
import com.electronic.Strore.entities.Product;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDto {

    private int cartItemId;
    private ProductDto productDto;
    private int quantity;
    private int totalPrice;

}
