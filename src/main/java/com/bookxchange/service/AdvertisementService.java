package com.bookxchange.service;

import com.bookxchange.dto.AdvertisementDTO;
import com.bookxchange.dto.AdvertisementSearchDTO;

import java.util.List;

public interface AdvertisementService {

    AdvertisementDTO getAdvertisementById(String id);

    void deleteAdvertisement(String id);

    AdvertisementDTO updateAdvertisement(AdvertisementDTO newAdvertisement,
                                         String id);

    AdvertisementDTO addNewAdvertisement(AdvertisementDTO newAdvertisement);

    List<AdvertisementDTO> getFourNewestAdvertisements();

    List<AdvertisementDTO> getAdvertisementsByCategory(String categoryId);

    List<AdvertisementDTO> getAdvertisementsByUserId(String userId);

    List<AdvertisementDTO> searchAdvertisementsByTitle(String title);

    AdvertisementDTO getAdvertisementByTitleAndUserId(String title, String userId);
}
