package com.electronic.Strore.repositories;

import com.electronic.Strore.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,String> {
}
