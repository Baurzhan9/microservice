package com.example.quiz.repository;

import com.example.quiz.entity.Exam;
import com.example.quiz.entity.ExamProtocol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamProtocolRepository extends JpaRepository<ExamProtocol, Integer> {
    ExamProtocol findOneById(Integer ExamProtocolId);
}
