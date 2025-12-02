package com.electronic.Strore.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name="username")
    private String name;

    @Column(name="user_email",unique = true)
    private String email;

    @Column(name="user_password",length=10)
    private String password;

    private String gender;

    @Column(name="user_image_name")
    private String imageName;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private List<Order> orders=new ArrayList<>();

}
