package com.example.course.model;


import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseList {
    private List<Course> courses;
}
