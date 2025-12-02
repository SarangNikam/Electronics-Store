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
public class OrderDto {
    private String orderId;
    private  String orderStatus;
    private String paymentStatus;

    private int orderAmount;

    private String address;
    private String billingPhone;
    private String billingName;
    private Date orderDate=new Date();
    private Date deliveredDate;

   // private User user;

    private List<OrderItemDto> orderItems=new ArrayList<>();
}
