package com.electronic.Strore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @Column(name = "category_id")
    private String categoryId;
    @Column(name="category_title",length = 50)
    private String title;
    @Column(name = "description",length = 100)
    private  String description;
    private String coverImage;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> product=new ArrayList<>();


}
