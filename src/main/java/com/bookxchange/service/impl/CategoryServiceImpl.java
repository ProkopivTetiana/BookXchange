package com.bookxchange.service.impl;

import com.bookxchange.dto.CategoryDTO;
import com.bookxchange.exception.EntityNotExistsException;
import com.bookxchange.mapper.CategoryMapper;
import com.bookxchange.repository.CategoryRepository;
import com.bookxchange.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    static final String CATEGORY_NOT_FOUND_BY_ID = "Category not found by id: ";
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDTO getCategoryById(String id) {
        checkThatCategoryExists(id);
        return categoryMapper.entityToDto(
                categoryRepository.getReferenceById(id));
    }

    @Override
    public void deleteCategory(String id) {
        checkThatCategoryExists(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO newCategory, String id) {
        checkThatCategoryExists(id);
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryMapper.updateCategory(category, newCategory);
                    return categoryMapper.entityToDto(categoryRepository
                            .save(category));
                }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public CategoryDTO addNewCategory(CategoryDTO newCategory) {
        return categoryMapper.entityToDto(
                categoryRepository.save(
                        categoryMapper.dtoToEntity(newCategory)
                )
        );
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.entitiesToDtos(categoryRepository.findAll());
    }

    private void checkThatCategoryExists(String id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotExistsException(CATEGORY_NOT_FOUND_BY_ID + id);
        }
    }
}