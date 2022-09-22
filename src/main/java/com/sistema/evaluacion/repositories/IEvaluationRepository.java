package com.sistema.evaluacion.repositories;

import com.sistema.evaluacion.models.entities.Category;
import com.sistema.evaluacion.models.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEvaluationRepository extends JpaRepository<Evaluation,Long> {

    List<Evaluation> findByCategory(Category category);

    List<Evaluation> findByEnable(Boolean enable);

    List<Evaluation> findByCategoryAndEnable(Category category,Boolean enable);

}
