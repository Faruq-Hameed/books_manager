package com.example.book_crud.services;

import org.springframework.stereotype.Service;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.example.book_crud.repositories.UserRepository;
import com.example.book_crud.models.Book;
import com.example.book_crud.models.User;
import com.example.book_crud.repositories.BookRepository;

@Service
public class BookService {
    private final UserRepository userRepo;
    private final BookRepository bookRepo;

    public BookService(UserRepository userRepo, BookRepository bookRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll(); // I am using the default interface here
    }

    public Book addBook(String title, int productionYear, Long authorId) {
        User author = userRepo.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Book book = new Book(title, productionYear, author);

        return bookRepo.save(book);
    }

    public Book updateBook(Long bookId, String title, Integer productionYear) {
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found to update"));

        if (title != null && !title.isEmpty()) {
            book.setTitle(title);
        }
        if (productionYear != null) {
            book.setProductionYear(productionYear);
        }

        return bookRepo.save(book);
    }

    public void deleteBook(Long id) {
        bookRepo.deleteById(id);
    }
}
