package com.example.courserating.repository;

import com.example.courserating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    List<User> findAll();
}
