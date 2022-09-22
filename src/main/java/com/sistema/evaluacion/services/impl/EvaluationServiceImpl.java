package com.sistema.evaluacion.services.impl;

import com.sistema.evaluacion.models.entities.Category;
import com.sistema.evaluacion.models.entities.Evaluation;
import com.sistema.evaluacion.repositories.IEvaluationRepository;
import com.sistema.evaluacion.services.IEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EvaluationServiceImpl implements IEvaluationService {

    @Autowired
    IEvaluationRepository evaluationRepository;

    @Override
    public Evaluation addEvaluation(Evaluation evaluation) {
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Evaluation updateEvaluation(Evaluation evaluation) {
        if (!evaluationRepository.findById(evaluation.getId()).isPresent()) {
            throw new EntityNotFoundException("La evaluacion que intenta actualizar no existe");
        }
        return evaluationRepository.save(evaluation);
    }

    @Override
    public Set<Evaluation> listEvaluation() {
        return new HashSet<Evaluation>(evaluationRepository.findAll());
    }

    @Override
    public Evaluation getEvaluation(Long id) {
        if (!evaluationRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("La evaluacion que busca no existe");
        }
        return evaluationRepository.findById(id).get();
    }

    @Override
    public void deleteEvaluation(Long id) {
        if (!evaluationRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("La evaluacion que intenta eliminar no existe");
        }
        evaluationRepository.deleteById(id);
    }

    @Override
    public List<Evaluation> listEvaluationOfCategory(Long id) {
        Category category = new Category();
        category.setId(id);
        return evaluationRepository.findByCategory(category);
    }

    @Override
    public List<Evaluation> getEvaluationEnable() {
        return evaluationRepository.findByEnable(true);
    }

    @Override
    public List<Evaluation> getEvaluationEnableOfCategory(Long id) {

        Category category = new Category();
        category.setId(id);
        return evaluationRepository.findByCategoryAndEnable(category, true);
    }
}
