package com.example.courserequest.Controller;

import com.example.courserequest.Producer;
import com.example.courserequest.Service.CourseService;
import com.example.courserequest.model.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/course/request")
public class CourseController {


    private final Producer producer;
    private CourseService CourseService;

    @Autowired
    public CourseController(Producer producer, CourseService CourseService) {
        this.producer = producer;
        this.CourseService = CourseService;
    }

    // TODO Ideally there should POST request
    @GetMapping
    public String sendMessageToKafkaTopic2(@RequestParam("userId") String userId,
                                           @RequestParam("courseId") Long courseId) {

        CourseRequest CourseRequest = new CourseRequest(userId, CourseService.getCourseById(courseId));
        this.producer.courseRequestNotify(CourseRequest);
        return "Your request sent successful!";
    }
}
