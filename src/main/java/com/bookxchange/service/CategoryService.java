package com.bookxchange.service;

import com.bookxchange.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO getCategoryById(String id);

    void deleteCategory(String id);

    CategoryDTO updateCategory(CategoryDTO newCategory,
                               String id);

    CategoryDTO addNewCategory(CategoryDTO newCategory);

    List<CategoryDTO> getAllCategories();

    List<CategoryDTO> getAllCategoriesByAdvertisementId(String id);

    List<CategoryDTO> addNewCategories(List<CategoryDTO> categories);
}
