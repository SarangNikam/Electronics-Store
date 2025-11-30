package com.electronic.Strore.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String productId;

    @NotBlank
    private String name;

    private String description;
   @NotBlank
    private double price;

    private double discount;

    private boolean stock;

    private int quantity;
}
