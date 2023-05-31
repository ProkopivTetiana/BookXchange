package com.bookxchange.controller;

import com.bookxchange.dto.AdvertisementCategoryDTO;
import com.bookxchange.service.AdvertisementCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/advertisement-categories")
@RequiredArgsConstructor
public class AdvertisementCategoryController {

    private final AdvertisementCategoryService advertisementCategoryService;

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementCategoryDTO> getAdvertisementCategoryById(
            @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementCategoryService.getAdvertisementCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<AdvertisementCategoryDTO> addNewAdvertisementCategory(
            @RequestBody @Validated AdvertisementCategoryDTO newAdvertisementCategory) {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementCategoryService.addNewAdvertisementCategory(newAdvertisementCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisementCategory(@PathVariable String id) {
        advertisementCategoryService.deleteAdvertisementCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertisementCategoryDTO> updateAdvertisementCategory(
            @RequestBody @Validated AdvertisementCategoryDTO newAdvertisementCategory,
            @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementCategoryService.updateAdvertisementCategory(newAdvertisementCategory, id));
    } 
}