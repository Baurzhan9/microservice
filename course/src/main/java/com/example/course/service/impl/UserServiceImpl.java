package com.example.course.service.impl;

import com.example.course.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceImpl {
    User getUserById(Long id);
}
