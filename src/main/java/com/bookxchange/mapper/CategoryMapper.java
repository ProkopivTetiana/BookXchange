package com.bookxchange.mapper;

import com.bookxchange.dto.CategoryDTO;
import com.bookxchange.model.Category;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CategoryMapper {
    Category dtoToEntity(CategoryDTO booDTO);

    CategoryDTO entityToDto(Category category);

    void updateCategory(@MappingTarget Category categoryFromDB,
                        CategoryDTO newCategory);

    List<CategoryDTO> entitiesToDtos(List<Category> categories);

    List<Category> dtosToEntities(List<CategoryDTO> categories);
}
