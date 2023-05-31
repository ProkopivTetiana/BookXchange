package com.bookxchange.controller;

import com.bookxchange.dto.CategoryDTO;
import com.bookxchange.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categorys")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(
            @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> addNewCategory(
            @RequestBody @Validated CategoryDTO newCategory) {
        return ResponseEntity.status(HttpStatus.OK).body(
                categoryService.addNewCategory(newCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable String id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<Iterable<CategoryDTO>> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(
                categoryService.getAllCategories());
    }
}