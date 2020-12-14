package com.example.course.service;

import com.example.course.model.Answer;
import com.example.course.model.Exam;
import com.example.course.model.ExamProtocol;
import com.example.course.model.Question;
//import com.example.course.repository.AnswerRepository;
//import com.example.course.repository.ExamProtocolRepository;
//import com.example.course.repository.ExamRepository;
//import com.example.course.repository.QuestionRepository;
//import com.example.course.repository.ExamProtocolRepository;
import com.example.course.service.impl.QuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExService {
    public static final double MAX_GRADE = 100; // 100 points

//    @Autowired
//    private ExamRepository ExamRepository;
//
//    @Autowired
//    private QuestionRepository questionRepo;
//
//    @Autowired
//    private AnswerRepository answerRepo;
//
//    @Autowired
//    private ExamProtocolRepository protocolRepo;

    @Autowired
    private QuizService QuizService;

    public Exam getRandomExam() {
        final int examCount = (int) QuizService.count();
        assert examCount > 0;
        final int examNumber = new Random().nextInt(examCount);
        return QuizService.findAll().get(examNumber);
    }

//    @Transactional
//    public int insertExam(ExamProtocol protocol) {
//        final ExamProtocol p = QuizService.save(protocol);
//        QuizService.flush();
//        return protocol.getId();
//    }
//
//    @Transactional
//    public ExamProtocol updateExamProtocol(ExamProtocol protocol) {
//        return QuizService.save(protocol);
//    }

    public Exam getExam(int examId) {
        final Exam exam = QuizService.findById(examId);
        return exam;
    }

    public ExamProtocol getExamProtocol(int protocolId) {
        return QuizService.findOneById(protocolId);
    }


    public List<Question> getQuestionsForExam(int examId) {
        final List<Question> questions = QuizService.findByExamId(examId);
        return questions;
    }

    public List<Answer> getAnswersForQuestion(int questionId) {
        final List<Answer> answers = QuizService.findByQuestionId(questionId);
        return answers;
    }

    public Question getNextQuestion(Exam exam, Set<Integer> ids) {
        final Set<Integer> identificators = new HashSet<>(ids);
        if (identificators.size() == 0) {
            identificators.add(0); // add to avoid null
        }
        return QuizService.findFirstByExamAndIdNotIn(exam, identificators);
    }

    /**
     * Process grade user answer on some question
     *
     * @param protocol user exam protocol
     * @param examId exam ID
     * @param userAnswers user answers as array of answer IDs
     */
    public void calcGrade(ExamProtocol protocol, int examId, List<Integer> userAnswers) {
        if (protocol == null || userAnswers == null) {
            throw new IllegalArgumentException("Invalid parameters on GRADE call");
        }

        final List<Answer> correctAnswers = QuizService.findByQuestionExamIdAndCorrect(examId, true);
        if (correctAnswers.size() == 0) {
            throw new IllegalArgumentException("You must specify correct answers!");
        }

        final float step = (float) (MAX_GRADE / correctAnswers.size());
        final Set<Integer> correctCount = new HashSet<>();
        final Set<Integer> incorrectCount = new HashSet<>();

        final Set<Integer> answers = userAnswers.stream().filter(a -> a > 0).collect(Collectors.toSet());

        float grade = 0;
        for (final Answer answer : correctAnswers) {
            final Integer id = answer.getId();
            if (answers.contains(id)) {
                grade += step;
                correctCount.add(id);
            } else {
                incorrectCount.add(id);
            }
        }
        // fix for multi-answers questions
        correctCount.removeAll(incorrectCount);

        // grade
        protocol.setCorrectAnswers(correctCount.size());
        protocol.setGrade(Math.round(grade));
    }

    private static final Logger logger = LoggerFactory.getLogger(ExService.class);

}