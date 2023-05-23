package com.bookxchange.service.impl;

import com.bookxchange.dto.BookCategoryDTO;
import com.bookxchange.exception.EntityNotExistsException;
import com.bookxchange.mapper.BookCategoryMapper;
import com.bookxchange.repository.BookCategoryRepository;
import com.bookxchange.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    static final String BOOK_CATEGORY_NOT_FOUND_BY_ID = "BookCategory not found by id: ";
    private final BookCategoryRepository bookCategoryRepository;
    private final BookCategoryMapper bookCategoryMapper;

    @Autowired
    public BookCategoryServiceImpl(BookCategoryRepository bookCategoryRepository,
                                   BookCategoryMapper bookCategoryMapper) {
        this.bookCategoryRepository = bookCategoryRepository;
        this.bookCategoryMapper = bookCategoryMapper;
    }

    @Override
    public BookCategoryDTO getBookCategoryById(String id) {
        checkThatBookCategoryExists(id);
        return bookCategoryMapper.entityToDto(
                bookCategoryRepository.getReferenceById(id));
    }

    @Override
    public void deleteBookCategory(String id) {
        checkThatBookCategoryExists(id);
        bookCategoryRepository.deleteById(id);
    }

    @Override
    public BookCategoryDTO updateBookCategory(BookCategoryDTO newBookCategory, String id) {
        checkThatBookCategoryExists(id);
        return bookCategoryRepository.findById(id)
                .map(bookCategory -> {
                    bookCategoryMapper.updateBookCategory(bookCategory, newBookCategory);
                    return bookCategoryMapper.entityToDto(bookCategoryRepository
                            .save(bookCategory));
                }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public BookCategoryDTO addNewBookCategory(BookCategoryDTO newBookCategory) {
        return bookCategoryMapper.entityToDto(
                bookCategoryRepository.save(
                        bookCategoryMapper.dtoToEntity(newBookCategory)
                )
        );
    }

    private void checkThatBookCategoryExists(String id) {
        if (!bookCategoryRepository.existsById(id)) {
            throw new EntityNotExistsException(BOOK_CATEGORY_NOT_FOUND_BY_ID + id);
        }
    }
}