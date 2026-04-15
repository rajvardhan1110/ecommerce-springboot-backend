package com.rajvardhan.ecommerce_springboot_backend.controllers;


import com.rajvardhan.ecommerce_springboot_backend.models.User;
import com.rajvardhan.ecommerce_springboot_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET ALL USERS
    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    // CREATE USER
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.createUser(user);
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}