package com.example.quiz.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;


@Entity
@Table(name = "ANSWER")
public class Answer extends AbstractPersistable<Integer> {
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @Column
    private String name; // answer
    @Column(name = "IS_CORRECT", nullable = false)
    private boolean correct = false; // is correct answer
}
