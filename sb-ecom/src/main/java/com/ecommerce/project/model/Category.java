package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.*;
import org.springframework.stereotype.Component;

/**
 * As we are using lombok which helps to reduce boilerplate code
 * we are commenting out getters and setters and constructor here
 * and using @Data, @NoArgsConstructor, @AllArgsConstructor etc...
 */

@Entity(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @NotBlank
    @Size(min = 3, message = "The category name must be at least 3 characters long")
    @Size(max = 30, message = "The category name is too long (max:30 characters allowed)")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;
}
