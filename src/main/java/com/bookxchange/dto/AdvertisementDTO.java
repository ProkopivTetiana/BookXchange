package com.bookxchange.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @NotEmpty
    private LocalDate publicationDate;

    @NotNull
    @NotEmpty
    private String bookAuthorName;

    @NotEmpty
    private String photo;

    @NotNull
    @NotEmpty
    private Boolean isForever;

    @NotNull
    @NotEmpty
    private String userId;

    @NotNull
    @NotEmpty
    private String categoryId;
}
