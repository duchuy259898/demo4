package com.example.demo4.service;

import com.example.demo4.dto.CategoryDto;
import com.example.demo4.model.Category;
import com.example.demo4.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        category.setImageUrl(categoryDto.getImageUrl());
        categoryRepository.save(category);
    }

    public void update(CategoryDto categoryDto ,Category category) {
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());
        category.setImageUrl(categoryDto.getImageUrl());
        categoryRepository.save(category);
    }

    public CategoryDto getCategory(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setImageUrl(category.getImageUrl());
        return categoryDto;
    }
    public List<CategoryDto> getListCategory() {
        List<Category> listCategory = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : listCategory){
            categoryDtoList.add(getCategory(category));
        }
        return categoryDtoList;
    }

}
