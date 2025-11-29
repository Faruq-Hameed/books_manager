package com.example.book_crud.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int productionYear;

    // Many books can belong to one author
    @ManyToOne
    @JoinColumn(name = "author_id") // creates author_id foreign key in DB
    private User author;

    // the function of the non‑parameterized constructor is to
    // let JPA/Hibernate (and other frameworks)
    // instantiate the entity automatically when fetching from the database.
    public Book() {
    }

    public Book(String title, int productionYear, User author) {
        this.title = title;
        this.productionYear = productionYear;
        this.author = author;
    }

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { // <-- This is what your updateBook method needs
        this.title = title;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) { // <-- And this one too
        this.productionYear = productionYear;
    }

}
