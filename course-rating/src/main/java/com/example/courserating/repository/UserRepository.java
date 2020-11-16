package com.example.courserating.repository;

import com.example.courserating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //    User findUserByUsername(String username);
    List<User> findAll();

    User findUserById(Long id);
}
