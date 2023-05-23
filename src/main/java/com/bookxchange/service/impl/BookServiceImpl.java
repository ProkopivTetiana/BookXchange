package com.bookxchange.service.impl;

import com.bookxchange.dto.BookDTO;
import com.bookxchange.exception.EntityNotExistsException;
import com.bookxchange.mapper.BookMapper;
import com.bookxchange.repository.BookRepository;
import com.bookxchange.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    static final String BOOK_NOT_FOUND_BY_ID = "Book not found by id: ";
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                              BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDTO getBookById(String id) {
        checkThatBookExists(id);
        return bookMapper.entityToDto(
                bookRepository.getReferenceById(id));
    }

    @Override
    public void deleteBook(String id) {
        checkThatBookExists(id);
        bookRepository.deleteById(id);
    }

    @Override
    public BookDTO updateBook(BookDTO newBook, String id) {
        checkThatBookExists(id);
        return bookRepository.findById(id)
                .map(book -> {
                    bookMapper.updateBook(book, newBook);
                    return bookMapper.entityToDto(bookRepository
                            .save(book));
                }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public BookDTO addNewBook(BookDTO newBook) {
        return bookMapper.entityToDto(
                bookRepository.save(
                        bookMapper.dtoToEntity(newBook)
                )
        );
    }

    private void checkThatBookExists(String id) {
        if (!bookRepository.existsById(id)) {
            throw new EntityNotExistsException(BOOK_NOT_FOUND_BY_ID + id);
        }
    }
}