package com.electronic.Strore.repositories;

import com.electronic.Strore.entities.Order;
import com.electronic.Strore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    List<Order> findByUser(User user);
    List<Order> findByUserUserId(int userId);
}
