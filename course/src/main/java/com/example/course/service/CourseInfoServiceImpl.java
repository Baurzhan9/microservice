package com.example.course.service;

import com.example.course.model.Course;
import com.example.course.service.impl.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CourseInfoServiceImpl implements CourseInfoService {

    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public ResponseEntity<?> findById(Long id) {
        return ResponseEntity.ok(restTemplate.getForObject(
                "http://course-information/course/" + id, Course.class));
    }


    @Transactional
    public List<Course> allCourse() {
        Course[] courses = restTemplate.getForObject(
                "http://course-information/courses", Course[].class);
        return Arrays.asList(courses);
    }


}
