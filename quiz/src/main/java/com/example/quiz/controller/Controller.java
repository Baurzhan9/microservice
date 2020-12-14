package com.example.quiz.controller;

import com.example.quiz.dto.EntryDTO;
import com.example.quiz.dto.ExamDTO;
import com.example.quiz.entity.Answer;
import com.example.quiz.entity.Exam;
import com.example.quiz.entity.ExamProtocol;
import com.example.quiz.entity.Question;
import com.example.quiz.repository.AnswerRepository;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.service.Converters;
import com.example.quiz.service.ExamService;
import com.example.quiz.service.QuizService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class Controller {

    @Value("${exam.time.minutes}")
    private Integer examTimeMins;

    @Autowired
    private QuizService quizService;

    @Autowired
    private ExamService examSvc;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;


    @GetMapping("/exam")
//    @RequestMapping(value = "/exam", method = RequestMethod.GET,headers="Accept=application/json")
    public List<Exam> getAllExam() {

        List<Exam> counts = new ArrayList<>();
        quizService.findAll().forEach(counts::add);
        return counts;
    }

    @GetMapping("/exam/{id}")
    public Exam findById(@PathVariable int id) {
        Exam exam;
        exam = quizService.findById(id);
        return exam;
    }

    @GetMapping("/questions/{examId}")
    public List<Question> getAllQuestionById(@PathVariable int examId) {

//        List<Question> counts = new ArrayList<>();
//        quizService.findByExamId(examId).forEach(counts::add);

        Exam exam;
        exam = quizService.findById(examId);

        List<Question> questions = questionRepository.findByExam(exam);
        return questions;
    }

    @RequestMapping(value = "/answers/{id}")
    @ResponseBody
    public List<EntryDTO> getAnswersForQuestion(@PathVariable("id") Integer questionId) {
        return Converters.answersToDTO(examSvc.getAnswersForQuestion(questionId));
    }

    @GetMapping("/examProtocol/{id}")
    public ExamProtocol findOneById(@PathVariable int id) {
        ExamProtocol exam;
        exam = quizService.findOneById(id);
        return exam;
    }
}
