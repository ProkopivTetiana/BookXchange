package com.bookxchange.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookxchange.dto.AdvertisementCategoryDTO;
import com.bookxchange.service.AdvertisementCategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/advertisements-categories")
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
        @RequestBody @Validated
        AdvertisementCategoryDTO newAdvertisementCategory) {
        return ResponseEntity.status(HttpStatus.OK).body(
            advertisementCategoryService.addNewAdvertisementCategory(
                newAdvertisementCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisementCategory(
        @PathVariable String id) {
        advertisementCategoryService.deleteAdvertisementCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertisementCategoryDTO> updateAdvertisementCategory(
        @RequestBody @Validated
        AdvertisementCategoryDTO newAdvertisementCategory,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            advertisementCategoryService.updateAdvertisementCategory(
                newAdvertisementCategory, id));
    }
}