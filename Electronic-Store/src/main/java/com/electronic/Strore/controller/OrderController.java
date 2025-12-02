package com.electronic.Strore.controller;

import com.electronic.Strore.dto.ApiResponseMessage;
import com.electronic.Strore.dto.CreateOrderRequest;
import com.electronic.Strore.dto.OrderDto;
import com.electronic.Strore.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody CreateOrderRequest request){
        OrderDto order = orderService.createOrder(request);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> removeOrder(@PathVariable String orderId){
        orderService.removeOrder(orderId);
        return new ResponseEntity<>("Order deleted succefully",HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getAllOrderByUser(@PathVariable int userId){
        List<OrderDto> ordersOfUser = orderService.getOrdersOfUser(userId);
        return new ResponseEntity<>(ordersOfUser,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrder(@PathVariable int userId){
        List<OrderDto> allOrders = orderService.getAllOrders(userId);
        return new ResponseEntity<>(allOrders,HttpStatus.OK);
    }
}
