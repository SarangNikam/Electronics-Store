package com.electronic.Strore.services.impl;

import com.electronic.Strore.dto.CreateOrderRequest;
import com.electronic.Strore.dto.OrderDto;
import com.electronic.Strore.entities.*;
import com.electronic.Strore.exception.BadApiRequestException;
import com.electronic.Strore.exception.ResourceNotFoundException;
import com.electronic.Strore.repositories.CartRepository;
import com.electronic.Strore.repositories.OrderRepository;
import com.electronic.Strore.repositories.UserRepository;
import com.electronic.Strore.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public OrderDto createOrder(CreateOrderRequest orderDto) {
        int userId = orderDto.getUserId();
        String cartId = orderDto.getCartId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        List<CartItem> items = cart.getItems();
        if (items.isEmpty()) {
            throw new BadApiRequestException("No item in cart");
        }

        Order order = Order.builder()
                .billingName(orderDto.getBillingName())
                .billingPhone(orderDto.getBillingPhone())
                .address(orderDto.getAddress())
                .deliveredDate(null)
                .paymentStatus(orderDto.getPaymentStatus())
                .orderDate(new Date())
                .orderStatus(orderDto.getOrderStatus())
                .orderId(UUID.randomUUID().toString())
                .user(user)
                .build();

        AtomicReference<Integer> orderAmount = new AtomicReference<>(0);

        List<OrderItem> orderItems = items.stream().map(cartItem -> {
            OrderItem orderItem = OrderItem.builder()
                    .quantity(cartItem.getQuantity())
                    .product(cartItem.getProduct())
                    .totalPrice((int) (cartItem.getQuantity() * cartItem.getProduct().getPrice()))
                    .order(order)
                    .build();

            orderAmount.updateAndGet(v -> v + orderItem.getTotalPrice());
            return orderItem;

        }).collect(Collectors.toList());

        order.setOrderItems(orderItems);
        order.setOrderAmount(orderAmount.get());

        cart.getItems().clear();
        cartRepository.save(cart);

        Order savedOrder = orderRepository.save(order);
        return mapper.map(savedOrder, OrderDto.class);
    }

    @Override
    public void removeOrder(String order_id) {
        Order order = orderRepository.findById(order_id).orElseThrow(() -> new ResourceNotFoundException("order not found"));
        orderRepository.delete(order);
    }

    @Override
    public List<OrderDto> getOrdersOfUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found"));
        List<Order> orders = orderRepository.findByUser(user);
        List<OrderDto> orderDtos = orders.stream().map(order -> mapper.map(order, OrderDto.class)).collect(Collectors.toList());
        return orderDtos;
    }

    @Override

    public List<OrderDto> getAllOrders(int userId) {
        List<Order> orderList = orderRepository.findByUserUserId(userId);

        List<OrderDto> orderDtos = orderList.stream()
                .map(order -> mapper.map(order, OrderDto.class))
                .toList();
        return orderDtos;
    }

}
