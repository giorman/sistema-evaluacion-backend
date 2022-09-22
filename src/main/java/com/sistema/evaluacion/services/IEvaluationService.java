package com.sistema.evaluacion.services;

import com.sistema.evaluacion.models.entities.Evaluation;

import java.util.List;
import java.util.Set;

public interface IEvaluationService {

    Evaluation addEvaluation(Evaluation evaluation);

    Evaluation updateEvaluation(Evaluation evaluation);

    Set<Evaluation> listEvaluation();

    Evaluation getEvaluation(Long id);

    void deleteEvaluation(Long id);

    List<Evaluation> listEvaluationOfCategory(Long id);

    List<Evaluation> getEvaluationEnable();

    List<Evaluation> getEvaluationEnableOfCategory(Long id);
}
