package com.example.quiz.service.impl;

import com.example.quiz.entity.Answer;
import com.example.quiz.entity.Exam;
import com.example.quiz.entity.ExamProtocol;
import com.example.quiz.entity.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface QuizServiceImpl {
    List<Answer> findByQuestion(Question question);

    List<Answer> findByQuestionId(Integer questionId);

    List<Answer> findByQuestionExamIdAndCorrect(Integer examId, Boolean isCorrect);

    ExamProtocol findOneById(Integer ExamProtocolId);

    Exam findById(Integer examId);
    List<Exam> findAll();
    long count();

    List<Question> findByExam(Exam exam);

    List<Question> findByExamId(Integer examId);

    // find first not answered question by exam
    Question findFirstByExamAndIdNotIn(Exam exam, Set<Integer> ids);

    int countByExam(Exam exam);
}
