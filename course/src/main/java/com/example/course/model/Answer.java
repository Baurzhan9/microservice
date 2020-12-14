package com.example.course.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Answer extends AbstractPersistable<Integer> {
//    public Question getQuestion() {
//        return question;
//    }
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "QUESTION_ID")
//    private Question question;


    private String name; // answer
    private boolean correct = false; // is correct answer
}
