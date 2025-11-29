package com.example.book_crud.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;

@Entity // makes class a DB table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto ID
    private Long id;

    private String name;

    // A user can have many books
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    @CreationTimestamp
    private LocalDateTime createdAt; // auto set in first insertion of the row

    @CreationTimestamp
    private LocalDateTime updatedAt; // auto-updated when the row changes

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    // Getters and setters
    // Why getters and setters?
    // - In practice, you almost always getters and setters because:
    // - Frameworks (like Spring Data) and libraries often rely on them.
    // - They make your entity usable in business logic, DTOs, and serialization
    // (e.g., JSON).
    // - IDEs and tools expect them for clean encapsulation.
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
