package com.electronic.Strore.dto;

import com.electronic.Strore.entities.OrderItem;
import com.electronic.Strore.entities.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateOrderRequest {

    private String cartId;
    private  int userId;
    private  String orderStatus="PENDING";
    private String paymentStatus="NOTPAID";
    private String address;
    private String billingPhone;
    private String billingName;



}
