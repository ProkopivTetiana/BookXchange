package com.bookxchange.mapper;

import com.bookxchange.dto.BookCategoryDTO;
import com.bookxchange.model.BookCategory;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BookCategoryMapper {
    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "book.id", source = "bookId")
    BookCategory dtoToEntity(BookCategoryDTO bookDTO);

    @Mapping(target = "bookId", source = "book.id")
    @Mapping(target = "categoryId", source = "category.id")
    BookCategoryDTO entityToDto(BookCategory book);

    @Mapping(target = "category.id", source = "categoryId")
    @Mapping(target = "book.id", source = "bookId")
    void updateBookCategory(@MappingTarget BookCategory bookFromDB,
                                 BookCategoryDTO newBookCategory);
}
