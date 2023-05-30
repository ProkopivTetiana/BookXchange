package com.bookxchange.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String authorFullName;

    @NotNull
    @NotEmpty
    private Integer publicationYear;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private String image;
}
