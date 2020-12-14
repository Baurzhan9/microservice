package com.example.quiz.service;

import com.example.quiz.dto.EntryDTO;
import com.example.quiz.dto.QuestionDTO;
import com.example.quiz.entity.Answer;
import com.example.quiz.entity.Question;

import java.util.List;
import java.util.stream.Collectors;

public class Converters {
    public static List<QuestionDTO> questionsToDTO(List<Question> questions) {
        return questions.stream().map(q -> new QuestionDTO(q)).collect(Collectors.toList());
    }
    
    public static List<EntryDTO> answersToDTO(List<Answer> answers) {
        return answers.stream().map(q -> new EntryDTO(q.getId(), q.getName())).collect(Collectors.toList());
    }
}
