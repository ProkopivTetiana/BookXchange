package com.bookxchange.mapper;

import com.bookxchange.dto.AdvertisementDTO;
import com.bookxchange.dto.AdvertisementSearchDTO;
import com.bookxchange.model.Advertisement;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AdvertisementMapper {


    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "user.id", source = "userId")
    Advertisement dtoToEntity(AdvertisementDTO advertisementDTO);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "userId", source = "user.id")
    AdvertisementDTO entityToDto(Advertisement advertisement);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "userId", source = "user.id")
    List<AdvertisementDTO> entitiesToDtos(List<Advertisement> advertisements);

    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "user.id", source = "userId")
    void updateAdvertisement(@MappingTarget Advertisement bookFromDB,
                             AdvertisementDTO newAdvertisement);

    List<Advertisement> dtosSearchToEntities(List<AdvertisementSearchDTO> advertisementSearchDTO);

    List<AdvertisementSearchDTO> entitiesToSearchDtos(List<Advertisement> advertisement);

}
