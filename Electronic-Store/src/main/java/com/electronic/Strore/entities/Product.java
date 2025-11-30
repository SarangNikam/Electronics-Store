package com.electronic.Strore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    private String productId;
    @Column(name = "product_name")
    @NotBlank
    private String name;
    @Column(name = "product_description",length = 100)
    private String description;
    @Column(name = "price")
    private double price;
    @Column(name = "Discount")
    private double discount;
    @Column(name = "Availability")
    private boolean stock;
    @Column(name = "quantity")
    private int quantity;



}
