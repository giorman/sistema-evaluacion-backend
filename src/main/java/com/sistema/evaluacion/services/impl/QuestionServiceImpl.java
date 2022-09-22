package com.sistema.evaluacion.services.impl;

import com.sistema.evaluacion.exceptions.NumberMaxQuestionOfEvaluationException;
import com.sistema.evaluacion.models.dtos.ResultDto;
import com.sistema.evaluacion.models.entities.Evaluation;
import com.sistema.evaluacion.models.entities.Question;
import com.sistema.evaluacion.repositories.IQuestionRepository;
import com.sistema.evaluacion.services.IEvaluationService;
import com.sistema.evaluacion.services.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

@Service
public class QuestionServiceImpl implements IQuestionService {

    @Autowired
    IQuestionRepository questionRepository;

    @Autowired
    IEvaluationService evaluationService;

    @Override
    public Question addQuestion(Question question) {

        Set<Question> questions = questionRepository.findQuestionsByEvaluation(question.getEvaluation());
        Evaluation evaluation = new Evaluation();
        evaluation = evaluationService.getEvaluation(question.getEvaluation().getId());
        if (evaluation.getQuestion().size() >= evaluation.getNumberQuestion()) {

            throw new NumberMaxQuestionOfEvaluationException("Se supero el numero de preguntas asignado para este examen");
        }
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        if (!questionRepository.findById(question.getId()).isPresent()){
            throw new EntityNotFoundException("La pregunta que intenta actualizar no existe");
        }
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestion(Long id) {
        if (!questionRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("La pregunta que esta consultando no existe");
        }
        return questionRepository.findById(id).get();
    }

    @Override
    public Set<Question> getQuestionOfEvaluation(Long id) {
        Evaluation evaluation = new Evaluation();
        evaluation.setId(id);
        return questionRepository.findQuestionsByEvaluation(evaluation);
    }

    @Override
    public ResultDto getResult(List<Question> questions) {
        double pointMax = 0;
        int corrects = 0;
        int intent = 0;

        for (Question q : questions) {
            Question question = questionRepository.findById(q.getId()).get();
            if (question.getResponseCorrect().equals(q.getResponseUser())) {
                corrects++;
                double point = questions.get(0).getEvaluation().getPointMax() / questions.size();
                pointMax += point;
            }
            if (q.getResponseUser() != null) {
                intent++;
            }
        }

        ResultDto resultDto = new ResultDto();
        resultDto.setPointMax(pointMax);
        resultDto.setNumberCorrect(corrects);
        resultDto.setIntent(intent);
        return resultDto;
    }

    @Override
    public void deleteQuestion(Long id) {
        if (!questionRepository.findById(id).isPresent()){
            throw new EntityNotFoundException("La pregunta que intenta eliminar no existe");
        }
        questionRepository.deleteById(id);
    }
}
