package com.sistema.evaluacion.services;

import com.sistema.evaluacion.models.dtos.ResultDto;
import com.sistema.evaluacion.models.entities.Question;

import java.util.List;
import java.util.Set;

public interface IQuestionService {

    Question addQuestion(Question question);

    Question updateQuestion(Question question);

    Question getQuestion(Long id);

    void deleteQuestion(Long id);

    Set<Question> getQuestionOfEvaluation(Long id);

    ResultDto getResult(List<Question> questions);



}
