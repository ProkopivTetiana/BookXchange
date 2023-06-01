package com.bookxchange.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDTO {

    private String id;

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String description;

    private LocalDate publicationDate;

    @NotNull
    @Positive
    private Integer publicationYear;

    @NotNull
    @NotEmpty
    private String bookAuthorFullName;

    @NotEmpty
    private String photo;

    @NotNull
    @NotEmpty
    private String time;

    @NotNull
    @NotEmpty
    private String userId;

    @NotNull
    @NotEmpty
    private String categoryId;
}
