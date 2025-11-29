package com.electronic.Strore.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String categoryId;
    @NotBlank
    @Size(min = 3,max=20,message = "Invalid name!!")
    private String title;
    @NotBlank(message = "Description required!!")
    private  String description;
    @NotBlank
    private String coverImage;
}
