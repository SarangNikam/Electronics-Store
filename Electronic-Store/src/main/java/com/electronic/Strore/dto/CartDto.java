package com.electronic.Strore.dto;

import com.electronic.Strore.entities.CartItem;
import com.electronic.Strore.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {

    private String cartId;
    private Date createdAt;

    private User user;

    private List<CartItem> items=new ArrayList<>();
}
