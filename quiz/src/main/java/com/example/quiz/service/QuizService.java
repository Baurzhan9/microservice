package com.example.quiz.service;

import com.example.quiz.entity.Answer;
import com.example.quiz.entity.Exam;
import com.example.quiz.entity.ExamProtocol;
import com.example.quiz.entity.Question;
import com.example.quiz.repository.AnswerRepository;
import com.example.quiz.repository.ExamProtocolRepository;
import com.example.quiz.repository.ExamRepository;
import com.example.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class QuizService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamProtocolRepository examProtocolRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    public List<Answer> findByQuestion(Question question) {
        return answerRepository.findByQuestion(question);
    }

    @Transactional
    public List<Answer> findByQuestionId(Integer questionId){
        return answerRepository.findByQuestionId(questionId);
    }

    @Transactional
    public List<Answer> findByQuestionExamIdAndCorrect(Integer examId, Boolean isCorrect){
        return answerRepository.findByQuestionExamIdAndCorrect(examId, isCorrect);
    }

    @Transactional
    public ExamProtocol findOneById(Integer ExamProtocolId){
        return  examProtocolRepository.findOneById(ExamProtocolId);
    }

    @Transactional
    public Exam findById(Integer examId){
        return examRepository.findOneById(examId);
    }

    @Transactional
    public List<Exam> findAll(){
        return examRepository.findAll();
    }

    @Transactional
    public long count(){
        return examRepository.count();
    }

    @Transactional
    public List<Question> findByExam(Exam exam){
        return questionRepository.findByExam(exam);
    }

    @Transactional
    public List<Question> findByExamId(Integer examId){
        return questionRepository.findByExamId(examId);
    }

    @Transactional
    public Question findFirstByExamAndIdNotIn(Exam exam, Set<Integer> ids){
        return questionRepository.findFirstByExamAndIdNotIn(exam, ids);
    }

}
