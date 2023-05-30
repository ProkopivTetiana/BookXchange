package com.bookxchange.service;

import com.bookxchange.dto.BookDTO;

public interface BookService {

    BookDTO getBookById(String id);

    void deleteBook(String id);

    BookDTO updateBook(BookDTO newBook,
                       String id);

    BookDTO addNewBook(BookDTO newBook);
}
