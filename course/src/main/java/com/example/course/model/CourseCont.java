package com.example.course.model;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseCont {
    private Long id;
    private String title;
    private String description;
}
