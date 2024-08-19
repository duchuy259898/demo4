package com.example.demo4.controller;

import com.example.demo4.common.ApiResponse;
import com.example.demo4.dto.CategoryDto;
import com.example.demo4.model.Category;
import com.example.demo4.repository.CategoryRepository;
import com.example.demo4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> add(@RequestBody CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
        return new ResponseEntity<>(new ApiResponse(true,"them thanh cong",null), HttpStatus.CREATED);
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> uypdate(@PathVariable("categoryId") int categoryId, @RequestBody CategoryDto categoryDto){
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if(!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false,"category not found",null), HttpStatus.NOT_FOUND);
        }
        categoryService.update(categoryDto,optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true,"category updated",null), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CategoryDto>> listCategory() {
        List<CategoryDto> listCategory = categoryService.getListCategory();
        return new ResponseEntity<>(listCategory,HttpStatus.OK);
    }

}
