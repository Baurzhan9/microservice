package com.example.courserating.controller;

import com.example.courserating.model.User;
import com.example.courserating.repository.UserRepository;
import com.example.courserating.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository UserRepository;

    @GetMapping("/users")
    public List<User> allCourses() {
        List<User> users = userService.findAll();

        List<User> counts = new ArrayList<>();
//        counts.add(users.id);

//        List<Course> counts = courseInfoService.allCourse();
        List<User> courseLists = new ArrayList();

        User courseList = new User();
        courseList.setId(1L);
        courseList.setUsername("Ann");
        courseList.setPassword("qwe");
        courseLists.add(courseList);

//        userService.findAll().forEach(counts::add);
        return courseLists;


//        return users;
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return UserRepository.findUserById(1L);

    }

}