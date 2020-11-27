package com.example.notifyservice.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseRequest {

    private String userId;
    private Course course;

    @Override
    public String toString() {
        return "CourseRequest{" +
                "userId='" + userId + '\'' +
                ", course=" + course +
                '}';
    }
}

