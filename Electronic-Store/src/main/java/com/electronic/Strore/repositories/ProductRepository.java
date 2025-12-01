package com.electronic.Strore.repositories;

import com.electronic.Strore.entities.Product;
import com.electronic.Strore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,String> {

    Optional<Product> findByPrice(double price);
    List<Product> findByDiscount(double discount);

    List<Product> findByNameContaining(String keyword);
}
