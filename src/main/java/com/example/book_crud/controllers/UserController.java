package com.example.book_crud.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.book_crud.models.User;
import com.example.book_crud.services.UserService;

@RestController // decorator that marks this class as a controller
@RequestMapping("/users") // making controller accessible as /users
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

   @PostMapping
public User createUser(@RequestBody User user) {
    System.out.println("User from controller is :" + user.getName());
    return userService.createUser(user.getName());
}


    @GetMapping // available with Get at /users
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getUser(id);
    }

    @GetMapping(params = "name") // GET /users?name=Alice
    public User getUserByName(@RequestParam String name) {
        return userService.getUserByName(name);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
            @RequestBody String name) {
        return userService.updateUser(id, name);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
