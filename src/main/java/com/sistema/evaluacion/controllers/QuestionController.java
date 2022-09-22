package com.sistema.evaluacion.controllers;


import com.sistema.evaluacion.models.dtos.ResultDto;
import com.sistema.evaluacion.models.entities.Question;
import com.sistema.evaluacion.services.IEvaluationService;
import com.sistema.evaluacion.services.IQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/v1/")
@Api(tags = "Controlador de Preguntas")
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @Autowired
    private IEvaluationService evaluationService;

    @GetMapping("question/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Consultar una pregunta")
    public Question getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @GetMapping("question/evaluation/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Lista de preguntas  de una evaluacion")
    public Set<Question> listQuestionOfEvaluationAdmin(@PathVariable Long id) {
        return questionService.getQuestionOfEvaluation(id);
    }

    @PostMapping("question")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Agregar una pregunta")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @PutMapping("question")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Actualizar una pregunta")
    public Question updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("question/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Eliminar una pregunta")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @PostMapping("result/evaluation")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Devuelve el resultado de la evaluacion")
    public ResultDto resultEvaluation(@RequestBody List<Question> questions) {

        return questionService.getResult(questions);
    }
}
