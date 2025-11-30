package com.example.book_crud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.book_crud.models.User;
import com.example.book_crud.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUser(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(String name) {
        System.out.println("name is " + name);
        User user = new User(name);
        // System.out.println("User is = " + user);
        return userRepo.save(user);
    }

    public User updateUser(Long id, String name) {
        User user = getUser(id); // reuse method
        user.setName(name);
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        getUser(id);
        userRepo.deleteById(id);
    }

    public User getUserByName(String name) {
        User user = userRepo.findByName(name);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user;
    }
}
