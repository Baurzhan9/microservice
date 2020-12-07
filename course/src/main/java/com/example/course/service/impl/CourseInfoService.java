package com.example.course.service.impl;


import com.example.course.model.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseInfoService {
    ResponseEntity<?> findById(Long id);
    Course findCourseById(Long id);
    List<Course> allCourse();

}
