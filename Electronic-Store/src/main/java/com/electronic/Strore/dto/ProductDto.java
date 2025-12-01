package com.electronic.Strore.dto;

import com.electronic.Strore.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be greater than 0")
    private Double price;

    private Double discount;

    @NotNull(message = "Stock status is required")
    private Boolean stock;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than 0")
    private Integer quantity;

    private CategoryDto categoryDto;

}
