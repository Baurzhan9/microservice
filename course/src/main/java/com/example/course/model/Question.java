package com.example.course.model;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question extends AbstractPersistable<Integer> {

//    public Exam getExam() {
//        return exam;
//    }
//
//    public void setExam(Exam exam) {
//        this.exam = exam;
//    }
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "EXAM_ID")
//    private Exam exam;

    private String name;
    private boolean multiAnswer = false;
}
