package com.example.demo4.service;

import com.example.demo4.dto.ProductDto;
import com.example.demo4.model.Category;
import com.example.demo4.model.Product;
import com.example.demo4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void add(ProductDto productDto , Category category) {
       productRepository.save(getProduct(productDto, category));
    }

    public Product getProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        product.setProductName(productDto.getProductName());
        product.setCategory(category);
        return product;
    }
}
