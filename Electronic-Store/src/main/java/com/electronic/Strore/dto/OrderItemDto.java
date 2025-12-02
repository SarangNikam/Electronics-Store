package com.electronic.Strore.dto;

import com.electronic.Strore.entities.Order;
import com.electronic.Strore.entities.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderItemDto {
    private int orderItemId;

    private int quantity;
    private int totalPrice;

    private ProductDto product;

//    private Order order;
}

