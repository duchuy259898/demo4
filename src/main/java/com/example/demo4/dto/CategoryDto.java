package com.example.demo4.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private int id;
    private String categoryName;
    private String description;
    private String imageUrl;
}
