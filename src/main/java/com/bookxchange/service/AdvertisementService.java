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

    List<AdvertisementDTO> getFiveNewestAdvertisements();

    List<AdvertisementDTO> getAdvertisementsByCategory(String categoryId);

    List<AdvertisementDTO> getAdvertisementsByUserId(String userId);

    List<AdvertisementSearchDTO> searchAdvertisementsByTitle(String title);

    AdvertisementDTO getAdvertisementByNameAndUserId(String title, String userId);
}
