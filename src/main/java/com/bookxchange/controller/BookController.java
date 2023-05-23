package com.bookxchange.controller;

import com.bookxchange.dto.BookDTO;
import com.bookxchange.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(
            @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<BookDTO> addNewBook(
            @RequestBody @Validated BookDTO newBook) {
        return ResponseEntity.status(HttpStatus.OK).body(
                bookService.addNewBook(newBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateFootballer(
            @RequestBody @Validated BookDTO newBook,
            @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                bookService.updateBook(newBook, id));
    }
}