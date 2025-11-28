package com.electronic.Strore.dto;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UserDto {

    private Integer userId;
    private String name;
    private String email;
    private String password;
    private String gender;
    private String imageName;
}
