package com.bookxchange.mapper;

import com.bookxchange.dto.BookDTO;
import com.bookxchange.model.Book;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BookMapper {
    Book dtoToEntity(BookDTO bookDTO);

    BookDTO entityToDto(Book book);

    void updateBook(@MappingTarget Book bookFromDB,
                    BookDTO newBook);
}
