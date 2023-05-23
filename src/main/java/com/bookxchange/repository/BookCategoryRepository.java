package com.bookxchange.repository;

import com.bookxchange.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, String> {
}
