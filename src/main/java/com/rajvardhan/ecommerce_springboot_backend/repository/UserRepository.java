package com.rajvardhan.ecommerce_springboot_backend.repository;

import com.rajvardhan.ecommerce_springboot_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
