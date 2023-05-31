package com.bookxchange.mapper;

import com.bookxchange.dto.AdvertisementCategoryDTO;
import com.bookxchange.model.AdvertisementCategory;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AdvertisementCategoryMapper {
    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "advertisement.id", source = "advertisementId")
    AdvertisementCategory dtoToEntity(AdvertisementCategoryDTO advertisementDTO);

    @Mapping(target = "advertisementId", source = "advertisement.id")
    @Mapping(target = "categoryId", source = "category.id")
    AdvertisementCategoryDTO entityToDto(AdvertisementCategory advertisement);

    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "advertisement.id", source = "advertisementId")
    void updateAdvertisementCategory(@MappingTarget AdvertisementCategory advertisementFromDB,
                            AdvertisementCategoryDTO newAdvertisementCategory);
}
