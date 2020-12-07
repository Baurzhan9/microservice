package com.example.course.service;

import com.example.course.model.Course;
import com.example.course.service.impl.CourseInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
//    @HystrixCommand(fallbackMethod = "fallbackfindById")
    @HystrixCommand(
            fallbackMethod = "fallbackfindById",
            threadPoolKey = "findById",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
//                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
//                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            }
    )

    public ResponseEntity<?> findById(Long id) {
        return ResponseEntity.ok(restTemplate.getForObject(
                "http://course-information/course/" + id, Course.class));
    }

    @Override
    public Course findCourseById(Long id) {
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

//        return restTemplate.getForObject(
//                "http://course-information/course/" + id, Course.class);
       return restTemplate.exchange("http://course-information/course/" + id,
                HttpMethod.GET, entity, Course.class).getBody();
    }

    public List<Course> fallbackfindById(Long id, Throwable t) {
        Course course = new Course();
        List<Course> list = new ArrayList<>();
        list.add(new Course(-1L, "Not available", "Not available"));
        return list;
    }

    @Transactional
//    @HystrixCommand(fallbackMethod = "fallbackallCourse")
    @HystrixCommand(
            fallbackMethod = "fallbackallCourse",
            threadPoolKey = "allCourse",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
//                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
//                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            })


    public List<Course> allCourse() {

        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);


//        Course[] courses = restTemplate.getForObject(
//                "http://course-information/courses", Course[].class);
//        return Arrays.asList(courses);

        return Arrays.asList(restTemplate.exchange("http://course-information/courses",
                HttpMethod.GET, entity, Course[].class).getBody());
    }


    public List<Course> fallbackallCourse(Throwable t) {
        Course course = new Course();
        List<Course> list = new ArrayList<>();
        list.add(new Course(-1L, "Not Connected", "Not Connected"));
        return list;
    }

}
