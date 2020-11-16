package com.example.courserating.service.interfaces;

import com.example.courserating.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> findAll();

    User findById(Long id);

}
