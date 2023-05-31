package com.bookxchange.repository;

import com.bookxchange.model.AdvertisementCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementCategoryRepository extends JpaRepository<AdvertisementCategory, String> {
}
