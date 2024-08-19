package com.example.demo4.controller;

import com.example.demo4.common.ApiResponse;
import com.example.demo4.dto.ProductDto;
import com.example.demo4.model.Category;
import com.example.demo4.model.Product;
import com.example.demo4.repository.CategoryRepository;
import com.example.demo4.service.CategoryService;
import com.example.demo4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository CategoryRepository;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addproduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = CategoryRepository.findById(productDto.getCategoryId());
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false,"ko cos id",null), HttpStatus.BAD_REQUEST);
        }
        productService.add(productDto,optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true,"add thanh cong",null), HttpStatus.CREATED);
    }
}
