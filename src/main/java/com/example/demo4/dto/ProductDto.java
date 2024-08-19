package com.example.demo4.dto;

import com.example.demo4.model.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private int id;

    private String description;

    private double imageUrl;

    private int price;

    private String productName;

    private int categoryId;
}
