package com.bookxchange.service;

import com.bookxchange.dto.AdvertisementCategoryDTO;

public interface AdvertisementCategoryService {

    AdvertisementCategoryDTO getAdvertisementCategoryById(String id);

    void deleteAdvertisementCategory(String id);

    AdvertisementCategoryDTO updateAdvertisementCategory(AdvertisementCategoryDTO newAdvertisementCategory,
                                                         String id);

    AdvertisementCategoryDTO addNewAdvertisementCategory(AdvertisementCategoryDTO newAdvertisementCategory);
}
