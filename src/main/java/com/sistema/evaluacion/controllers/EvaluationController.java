package com.sistema.evaluacion.controllers;

import com.sistema.evaluacion.models.entities.Evaluation;
import com.sistema.evaluacion.services.IEvaluationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/")
@Api(tags = "Controlador de Evaluacion")
public class EvaluationController {

    @Autowired
    private IEvaluationService evaluationService;

    @GetMapping("list/evaluation")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Consultar lista de evaluacion")
    public Set<Evaluation> listEvaluation() {
        return evaluationService.listEvaluation();
    }

    @GetMapping("evaluation/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Consultar una evaluacion")
    public Evaluation getEvaluation(@PathVariable Long id) {
        return evaluationService.getEvaluation(id);
    }

    @PostMapping("evaluation")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Guardar una evaluacion")
    public Evaluation saveEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.addEvaluation(evaluation);
    }

    @PutMapping("evaluation")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualizar una evaluacion")
    public Evaluation updateEvaluation(@RequestBody Evaluation evaluation) {
        return evaluationService.updateEvaluation(evaluation);
    }

    @DeleteMapping("evaluation/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Eliminar una evaluacion")
    public void deleteEvaluation(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
    }

    @GetMapping("/evaluation/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Lista las evaluaciones por categoria")
    public List<Evaluation> listEvaluationByCategory(@PathVariable Long id) {
        return evaluationService.listEvaluationOfCategory(id);
    }

    @GetMapping("evaluation/enable")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Lista las evaluaciones activas")
    public List<Evaluation> listEvaluationEnable() {
        return evaluationService.getEvaluationEnable();
    }

    @GetMapping("evaluation/enable/category/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Lista las evaluaciones activas por categoria")
    public List<Evaluation> listEvaluationEnableByCategory(@PathVariable Long id) {
        return evaluationService.getEvaluationEnableOfCategory(id);
    }
}
