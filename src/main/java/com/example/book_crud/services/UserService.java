package com.example.book_crud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book_crud.models.User;
import com.example.book_crud.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUser(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(String name) {
        User user = new User(name);
        return repo.save(user);
    }

    public User updateUser(Long id, String name) {
        User user = getUser(id); // reuse method
        user.setName(name);
        return repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}
