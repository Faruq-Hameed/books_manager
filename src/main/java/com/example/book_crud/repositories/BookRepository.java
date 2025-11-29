package com.example.book_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.book_crud.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
