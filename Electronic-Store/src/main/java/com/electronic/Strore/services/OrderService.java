package com.electronic.Strore.services;

import com.electronic.Strore.dto.CreateOrderRequest;
import com.electronic.Strore.dto.OrderDto;

import java.util.List;

public interface OrderService {

    //create order
    OrderDto createOrder(CreateOrderRequest  orderDto);

    //delete order
    void removeOrder(String order_id);


    //get orders of user
    List<OrderDto> getOrdersOfUser(int userId);

    //get orders
    List<OrderDto> getAllOrders(int userId);

}
