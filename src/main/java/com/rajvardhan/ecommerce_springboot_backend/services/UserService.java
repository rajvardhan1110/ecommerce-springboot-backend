package com.rajvardhan.ecommerce_springboot_backend.services;

import com.rajvardhan.ecommerce_springboot_backend.models.User;
import com.rajvardhan.ecommerce_springboot_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // GET ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET USER BY ID
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    // CREATE USER
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // UPDATE USER
    public User updateUser(int id, User newUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(newUser.getName());
            return userRepository.save(existingUser);
        }

        return null;
    }

    // DELETE USER
    public String deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Deleted user with id: " + id;
        }
        return "User not found";
    }
}