package com.example.course.controller;

import com.example.course.model.ProtocolList;
import com.example.course.service.ExService;
import com.example.course.dto.EntryDTO;
import com.example.course.dto.ExamDTO;
import com.example.course.model.Exam;
import com.example.course.model.ExamProtocol;
import com.example.course.model.Question;
import com.example.course.service.Converters;

import com.example.course.service.impl.QuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QuizController {

    @Value("${exam.time.minutes}")
    private Integer examTimeMins;


    @Autowired
    private QuizService QuizService;

    @Autowired
    private ExService examSvc;



//    public QuizController(ExamService examService) {
//        this.ExamService = examService;
//    }

    @RequestMapping(value = {"/exam/{id}"})
    public String home(Model model, HttpServletRequest request, @PathVariable int id) {

        final Exam exam = QuizService.findById(id);

//        Map<String, String> states = new HashMap<String, String>();

        final List<Question> questions = examSvc.getQuestionsForExam(exam.getId());

//        final ExamProtocol protocol = new ExamProtocol();
//        protocol.setExam(exam);
//        protocol.setStart(Calendar.getInstance().getTime());
//        protocol.setQuestionCount(questions.size());

//        final int protocolId = examSvc.insertExam(protocol);

        model.addAttribute("results", new ExamDTO(1, exam.getId()));
        model.addAttribute("examName", String.format("Welcome to \"%s\"!", exam.getName()));
        model.addAttribute("questions", Converters.questionsToDTO(questions));

//        request.getSession().setAttribute("examStarted", protocol.getStart().getTime());
//        final int remaining = getRemainingTime(request);
//        model.addAttribute("examTime", remaining);

        return "exam";
//        return  QuizService.findById(id);
        }


//    private int getRemainingTime(HttpServletRequest request) {
//        final long start = (long) request.getSession().getAttribute("examStarted");
//        final int remaining = (int) ((examTimeMins * 60) - ((Calendar.getInstance().getTimeInMillis() - start) / 1000));
//        return remaining;
//    }

    @RequestMapping(value = "/examProtocol/{id}")
    @ResponseBody
    public ExamProtocol getExamProtocol(@PathVariable("id") Integer examId) {
        return examSvc.getExamProtocol(examId);
    }

    @RequestMapping(value = "/questions/{id}")
    @ResponseBody
    public List<Question> getQuestionsForExam(@PathVariable("id") Integer examId) {
        return examSvc.getQuestionsForExam(examId);
    }

    @RequestMapping(value = "/answers/{id}")
    @ResponseBody
    public List<EntryDTO> getAnswersForQuestion(@PathVariable("id") Integer questionId) {
        return Converters.answersToDTO(examSvc.getAnswersForQuestion(questionId));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submitResult(Model model, @ModelAttribute("results") ExamDTO frm, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            // TODO?
        }
        logger.info("Submit: {}", frm);
        request.getSession().removeAttribute("examId");
//
//        final ExamProtocol protocol = examSvc.getExamProtocol(frm.getId());
//        protocol.setFinish(Calendar.getInstance().getTime());
//
//        examSvc.calcGrade(protocol, frm.getExamId(), frm.getAnswers());
////        examSvc.updateExamProtocol(protocol);
//        logger.info("Submit: {}", protocol);
        return "redirect:/courses"
//                + protocol.getId()
                ;
    }

    @RequestMapping(value = "/stat/{id}", method = RequestMethod.GET)
    public String stat(Model model, @PathVariable("id") Integer protocolId) {
        if (protocolId < 1) {
            return "redirect:/courses";
        }
        final ExamProtocol protocol = examSvc.getExamProtocol(protocolId);
        if (protocol == null) {
            return "redirect:/courses";
        }
        logger.info("Stat: {}", protocol);
        final Exam exam = examSvc.getExam(protocol.getExam().getId());
        model.addAttribute("title", String.format("Your results for %s", exam.getName()));
        model.addAttribute("start", protocol.getStart());
        model.addAttribute("finish", protocol.getFinish());
        model.addAttribute("questionCount", 3);
        model.addAttribute("grade", protocol.getGrade());
        model.addAttribute("maxGrade", 100);
        return "stat";
    }

//    @RequestMapping(value = "/time")
//    @ResponseBody
//    public Integer timer(HttpServletRequest request) {
//        return getRemainingTime(request);
//    }

//    private User getUser() {
//        final String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        return userRepo.findByUsername(username);
//    }

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
}
