package com.example.quiz.repository;

import com.example.quiz.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
    Exam findOneById(Integer examId);
    List<Exam> findAll();
    long count();
}
