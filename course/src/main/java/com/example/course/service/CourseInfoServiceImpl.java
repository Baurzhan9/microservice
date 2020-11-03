package com.example.course.service;

import com.example.course.model.Course;
import com.example.course.service.impl.CourseInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseInfoServiceImpl implements CourseInfoService {

    @Autowired
    RestTemplate restTemplate;

    @Transactional
    @HystrixCommand(fallbackMethod = "fallbackfindById")
    public ResponseEntity<?> findById(Long id) {
        return ResponseEntity.ok(restTemplate.getForObject(
                "http://course-information/course/" + id, Course.class));
    }

    public List<Course> fallbackfindById(Long id, Throwable t){
        Course course = new Course();
        List<Course> list = new ArrayList<>();
        list.add(new Course(-1L, "Not available", "Not available"));
        return list;
    }

    @Transactional
    @HystrixCommand(fallbackMethod = "fallbackallCourse")
    public List<Course> allCourse() {
        Course[] courses = restTemplate.getForObject(
                "http://course-information/courses", Course[].class);
        return Arrays.asList(courses);
    }

    public List<Course> fallbackallCourse(Throwable t){
        Course course = new Course();
        List<Course> list = new ArrayList<>();
        list.add(new Course(-1L, "Not Connected", "Not Connected"));
        return list;
    }

}
