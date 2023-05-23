package com.bookxchange.service;

import com.bookxchange.dto.BookCategoryDTO;

public interface BookCategoryService {

    BookCategoryDTO getBookCategoryById(String id);

    void deleteBookCategory(String id);

    BookCategoryDTO updateBookCategory(BookCategoryDTO newBookCategory,
                             String id);

    BookCategoryDTO addNewBookCategory(BookCategoryDTO newBookCategory);
}
