package com.electronic.Strore.repositories;

import com.electronic.Strore.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {
}
