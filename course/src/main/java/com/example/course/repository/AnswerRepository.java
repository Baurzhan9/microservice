//package com.example.course.repository;
//
//import com.example.course.model.Answer;
//import com.example.course.model.Question;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface AnswerRepository extends JpaRepository<Answer, Integer> {
//    List<Answer> findByQuestion(Question question);
//
//    List<Answer> findByQuestionId(Integer questionId);
//
//    List<Answer> findByQuestionExamIdAndCorrect(Integer examId, Boolean isCorrect);
//}
