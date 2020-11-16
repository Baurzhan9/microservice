package com.example.course.model;


import lombok.*;
//import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {

    private Long id;
    private String title;
    private String description;

//    public Course(String title, String description) {
//        this.title = title;
//        this.description = description;
//    }
}
