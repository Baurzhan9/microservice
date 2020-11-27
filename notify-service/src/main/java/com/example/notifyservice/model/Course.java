package com.example.notifyservice.model;

import lombok.*;

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


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
