package com.example.course.controller;

import com.example.course.model.Course;
import com.example.course.model.CourseCont;
import com.example.course.service.impl.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseApi {

    @Autowired
    private CourseInfoService courseInfoService;

//    @RequestMapping(value = {"", "/index"})
    @GetMapping("/course")
    public String home(Model model, HttpServletRequest request) {
//    public ResponseEntity<?> getCourseList(){

        return "index";
//        return ResponseEntity.ok(courseLists);
    }
}
