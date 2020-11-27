package com.example.notifyservice;


import com.example.notifyservice.model.CourseRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class Consumer {


    @KafkaListener(topics = "course_requests", groupId = "group_id")
    public void consume(CourseRequest courseRequest) throws IOException {
        System.out.println(String.format("#### -> Notify user by email: -> %s",
                "User " + courseRequest.getUserId() + " purchased book "
                        + courseRequest.getCourse().toString()));
    }
}