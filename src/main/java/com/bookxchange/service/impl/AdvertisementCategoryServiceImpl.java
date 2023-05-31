package com.bookxchange.service.impl;

import com.bookxchange.dto.AdvertisementCategoryDTO;
import com.bookxchange.exception.EntityNotExistsException;
import com.bookxchange.mapper.AdvertisementCategoryMapper;
import com.bookxchange.repository.AdvertisementCategoryRepository;
import com.bookxchange.service.AdvertisementCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementCategoryServiceImpl implements AdvertisementCategoryService {

    static final String ADVERTISEMENT_CATEGORY_NOT_FOUND_BY_ID = "AdvertisementCategory not found by id: ";
    private final AdvertisementCategoryRepository advertisementCategoryRepository;
    private final AdvertisementCategoryMapper advertisementCategoryMapper;

    @Autowired
    public AdvertisementCategoryServiceImpl(AdvertisementCategoryRepository advertisementCategoryRepository,
                                            AdvertisementCategoryMapper advertisementCategoryMapper) {
        this.advertisementCategoryRepository = advertisementCategoryRepository;
        this.advertisementCategoryMapper = advertisementCategoryMapper;
    }

    @Override
    public AdvertisementCategoryDTO getAdvertisementCategoryById(String id) {
        checkThatAdvertisementCategoryExists(id);
        return advertisementCategoryMapper.entityToDto(
                advertisementCategoryRepository.getReferenceById(id));
    }

    @Override
    public void deleteAdvertisementCategory(String id) {
        checkThatAdvertisementCategoryExists(id);
        advertisementCategoryRepository.deleteById(id);
    }

    @Override
    public AdvertisementCategoryDTO updateAdvertisementCategory(AdvertisementCategoryDTO newAdvertisementCategory, String id) {
        checkThatAdvertisementCategoryExists(id);
        return advertisementCategoryRepository.findById(id)
                .map(bookCategory -> {
                    advertisementCategoryMapper.updateAdvertisementCategory(bookCategory, newAdvertisementCategory);
                    return advertisementCategoryMapper.entityToDto(advertisementCategoryRepository
                            .save(bookCategory));
                }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public AdvertisementCategoryDTO addNewAdvertisementCategory(AdvertisementCategoryDTO newAdvertisementCategory) {
        return advertisementCategoryMapper.entityToDto(
                advertisementCategoryRepository.save(
                        advertisementCategoryMapper.dtoToEntity(newAdvertisementCategory)
                )
        );
    }

    private void checkThatAdvertisementCategoryExists(String id) {
        if (!advertisementCategoryRepository.existsById(id)) {
            throw new EntityNotExistsException(ADVERTISEMENT_CATEGORY_NOT_FOUND_BY_ID + id);
        }
    }
}