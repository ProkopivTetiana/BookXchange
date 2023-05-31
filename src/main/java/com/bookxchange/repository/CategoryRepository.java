package com.bookxchange.repository;

import java.util.List;

import com.bookxchange.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query
    ("SELECT c FROM Category c join AdvertisementCategory ac where ac.advertisement.id = ?1")
    List<Category> findAllByAdvertisementId(String id);
}
