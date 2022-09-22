package com.sistema.evaluacion.repositories;

import com.sistema.evaluacion.models.entities.Evaluation;
import com.sistema.evaluacion.models.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IQuestionRepository extends JpaRepository<Question,Long> {

    Set<Question> findQuestionsByEvaluation(Evaluation evaluation);
}
