package com.example.course.service;

import com.example.course.dto.EntryDTO;
import com.example.course.dto.QuestionDTO;
import com.example.course.model.Answer;
import com.example.course.model.Question;

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
