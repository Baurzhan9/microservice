package com.example.quiz.repository;

import com.example.quiz.entity.Answer;
import com.example.quiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByQuestion(Question question);

    List<Answer> findByQuestionId(Integer questionId);

    List<Answer> findByQuestionExamIdAndCorrect(Integer examId, Boolean isCorrect);
}
