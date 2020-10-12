package com.example.courserating.controller;

import com.example.courserating.model.User;
import com.example.courserating.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping("/users")
    public List<User> allCourses() {
//        List<User> users = userService.findAll();

        List<User> counts = new ArrayList<>();
        userService.findAll().forEach(counts::add);
        return counts;


//        return users;
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return user;
    }

}