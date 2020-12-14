package com.example.course.service.impl;

import com.example.course.model.Answer;
import com.example.course.model.Exam;
import com.example.course.model.ExamProtocol;
import com.example.course.model.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface QuizService {
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

//    ExamProtocol save(ExamProtocol protocol);
//
//    void flush();
}
