package com.example.course.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Exam extends AbstractPersistable<Integer> {
    private String name;
    private String description;
}
