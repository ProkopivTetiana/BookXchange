package com.bookxchange.service.impl;

import com.bookxchange.dto.AdvertisementDTO;
import com.bookxchange.dto.AdvertisementSearchDTO;
import com.bookxchange.exception.EntityNotExistsException;
import com.bookxchange.mapper.AdvertisementMapper;
import com.bookxchange.repository.AdvertisementRepository;
import com.bookxchange.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementImpl implements AdvertisementService {

    static final String ADVERTISEMENT_NOT_FOUND_BY_ID = "Advertisement not found by id: ";
    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementMapper advertisementMapper;

    @Autowired
    public AdvertisementImpl(AdvertisementRepository advertisementRepository,
                             AdvertisementMapper advertisementMapper) {
        this.advertisementRepository = advertisementRepository;
        this.advertisementMapper = advertisementMapper;
    }

    @Override
    public AdvertisementDTO getAdvertisementById(String id) {
        checkThatAdvertisementExists(id);
        return advertisementMapper.entityToDto(
                advertisementRepository.getReferenceById(id));
    }

    @Override
    public void deleteAdvertisement(String id) {
        checkThatAdvertisementExists(id);
        advertisementRepository.deleteById(id);
    }

    @Override
    public AdvertisementDTO updateAdvertisement(AdvertisementDTO newAdvertisement, String id) {
        checkThatAdvertisementExists(id);
        return advertisementRepository.findById(id)
                .map(advertisement -> {
                    advertisementMapper.updateAdvertisement(advertisement, newAdvertisement);
                    return advertisementMapper.entityToDto(advertisementRepository
                            .save(advertisement));
                }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public AdvertisementDTO addNewAdvertisement(AdvertisementDTO newAdvertisement) {
        return advertisementMapper.entityToDto(
                advertisementRepository.save(
                        advertisementMapper.dtoToEntity(newAdvertisement)
                )
        );
    }

    @Override
    public List<AdvertisementDTO> getFourNewestAdvertisements() {
        return advertisementMapper.entitiesToDtos(
                advertisementRepository.getFourNewestAdvertisements());
    }

    @Override
    public List<AdvertisementDTO> getAdvertisementsByCategory(String categoryId) {
        return advertisementMapper.entitiesToDtos(
                advertisementRepository.getAdvertisementsByCategory(categoryId));
    }

    @Override
    public List<AdvertisementDTO> getAdvertisementsByUserId(String userId) {

        return advertisementMapper.entitiesToDtos(
                advertisementRepository.getAdvertisementsByUserId(userId));

    }

    @Override
    public List<AdvertisementSearchDTO> searchAdvertisementsByTitle(String title) {
        return advertisementMapper.entitiesToSearchDtos(
                advertisementRepository.searchAdvertisementsByTitle(title));
    }

    @Override
    public AdvertisementDTO getAdvertisementByTitleAndUserId(String title,
        String userId) {
        return advertisementMapper.entityToDto(
            advertisementRepository.getAdvertisementByTitleAndUserId(title, userId));
    }

    private void checkThatAdvertisementExists(String id) {
        if (!advertisementRepository.existsById(id)) {
            throw new EntityNotExistsException(ADVERTISEMENT_NOT_FOUND_BY_ID + id);
        }
    }
}