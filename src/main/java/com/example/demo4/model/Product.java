package com.example.demo4.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "imageurl")
    private double imageUrl;

    @Column(name = "price")
    private int price;

    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
