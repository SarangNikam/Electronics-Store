package com.electronic.Strore.repositories;

import com.electronic.Strore.entities.Cart;
import com.electronic.Strore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,String> {

    Optional<Cart> findByUser(User user);
}
