package com.bookxchange.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCategoryDTO {

    private String id;

    @NotNull
    @NotEmpty
    private String bookId;

    @NotNull
    @NotEmpty
    private String categoryId;
}
