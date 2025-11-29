package com.example.book_crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.book_crud.models.User;

//Spring Data JPA gives CRUD for free. I should only add others if they are
public interface UserRepository extends JpaRepository<User, Long> {
    /**Find by author name */
    User findByName(String name);

    /**Find authors whose name contains those keys */
    List<User> findAuthorsByName(String keyword);
}
