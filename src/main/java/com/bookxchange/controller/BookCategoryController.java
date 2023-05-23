package com.bookxchange.controller;

import com.bookxchange.dto.BookCategoryDTO;
import com.bookxchange.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book-categories")
@RequiredArgsConstructor
public class BookCategoryController {

    private final BookCategoryService bookcategoryService;

    @GetMapping("/{id}")
    public ResponseEntity<BookCategoryDTO> getBookCategoryById(
            @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                bookcategoryService.getBookCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<BookCategoryDTO> addNewBookCategory(
            @RequestBody @Validated BookCategoryDTO newBookCategory) {
        return ResponseEntity.status(HttpStatus.OK).body(
                bookcategoryService.addNewBookCategory(newBookCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCategory(@PathVariable String id) {
        bookcategoryService.deleteBookCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookCategoryDTO> updateFootballer(
            @RequestBody @Validated BookCategoryDTO newBookCategory,
            @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                bookcategoryService.updateBookCategory(newBookCategory, id));
    }
}