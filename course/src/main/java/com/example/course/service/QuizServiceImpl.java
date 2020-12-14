package com.example.course.service;

import com.example.course.model.*;
import com.example.course.service.impl.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Answer> findByQuestion(Question question) {
        return null;
    }

    @Override
    public List<Answer> findByQuestionId(Integer questionId) {
//        return ResponseEntity.ok(restTemplate.getForObject(
//                "http://quiz/answers/" + questionId, Answer.class));
         Answer[] answer = restTemplate.getForObject(
                "http://quiz/answers/" + questionId, Answer[].class);
        return Arrays.asList(answer);

    }

    @Override
    public List<Answer> findByQuestionExamIdAndCorrect(Integer examId, Boolean isCorrect) {
        return findByQuestionExamIdAndCorrect(examId, isCorrect);
    }

    @Override
    public ExamProtocol findOneById(Integer ExamProtocolId) {
//        return ResponseEntity.ok(restTemplate.getForObject(
//                "http://quiz/examProtocol/" + ExamProtocolId, ExamProtocol.class));

        return restTemplate.getForObject(
                "http://quiz/examProtocol/" + ExamProtocolId, ExamProtocol.class);
    }

    @Override
    public Exam findById(Integer examId) {
//        return ResponseEntity.ok(restTemplate.getForObject(
//                "http://quiz/exam/" + examId, Exam.class));

        return restTemplate.getForObject(
                "http://quiz/exam/" + examId, Exam.class);
    }

    @Override
    public List<Exam> findAll() {
//        return ResponseEntity.ok(restTemplate.getForObject(
//                "http://quiz/exam/", Exam.class));
        Exam[] exam = restTemplate.getForObject(
                "http://quiz/exam", Exam[].class);
        return Arrays.asList(exam);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public List<Question> findByExam(Exam exam) {
        return null;
    }

    @Override
    public List<Question> findByExamId(Integer examId) {
         Question[] question = restTemplate.getForObject(
                "http://quiz/questions/" + examId, Question[].class);
        return Arrays.asList(question);
    }

    @Override
    public Question findFirstByExamAndIdNotIn(Exam exam, Set<Integer> ids) {
        return null;
    }

    @Override
    public int countByExam(Exam exam) {
        return 0;
    }

//    @Override
//    public ExamProtocol save(ExamProtocol protocol) {
//        return null;
//    }
//
//    @Override
//    public void flush() {
//
//    }


}
