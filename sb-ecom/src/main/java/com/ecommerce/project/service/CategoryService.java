package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    Category getCategoryById(Long categoryId);

    Category getCategorybyName(String categoryName);

    CategoryDTO deleteCategoryById(Long categoryId);

    CategoryDTO updateCategoryById(Long categoryId, CategoryDTO categoryDTO);

    CategoryDTO createCategory(CategoryDTO categoryDTO);


}