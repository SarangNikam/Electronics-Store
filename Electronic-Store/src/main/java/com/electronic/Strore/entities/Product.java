package com.electronic.Strore.entities;

import jakarta.persistence.*;
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

    @NotBlank
    @Column(name = "product_name")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="categoryId")
    private Category category;



}
