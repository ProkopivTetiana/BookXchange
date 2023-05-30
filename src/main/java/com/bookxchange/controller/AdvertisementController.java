package com.bookxchange.controller;

import com.bookxchange.dto.AdvertisementDTO;
import com.bookxchange.dto.AdvertisementSearchDTO;
import com.bookxchange.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementDTO> getAdvertisementById(
            @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementService.getAdvertisementById(id));
    }

    @PostMapping
    public ResponseEntity<AdvertisementDTO> addNewAdvertisement(
            @RequestBody @Validated AdvertisementDTO newAdvertisement) {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementService.addNewAdvertisement(newAdvertisement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisement(@PathVariable String id) {
        advertisementService.deleteAdvertisement(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertisementDTO> updateFootballer(
            @RequestBody @Validated AdvertisementDTO newAdvertisement,
            @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementService.updateAdvertisement(newAdvertisement, id));
    }

    @GetMapping
    public ResponseEntity<List<AdvertisementDTO>> getFiveNewestAdvertisements() {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementService.getFiveNewestAdvertisements());
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsByCategory(
            @PathVariable String categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementService.getAdvertisementsByCategory(categoryId));
    }

    @GetMapping("/profile/{userId}")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsByUserId(
            @PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementService.getAdvertisementsByUserId(userId));
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<AdvertisementSearchDTO>> searchAdvertisementsByName(
            @PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(
                advertisementService.searchAdvertisementsByName(name));
    }
}