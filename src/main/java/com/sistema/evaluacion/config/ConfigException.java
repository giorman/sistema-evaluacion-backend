package com.sistema.evaluacion.config;

import com.sistema.evaluacion.exceptions.BadTokenJwtException;
import com.sistema.evaluacion.exceptions.ExpiredJwtException;
import com.sistema.evaluacion.exceptions.NonUniqueUsernameException;
import com.sistema.evaluacion.exceptions.NumberMaxQuestionOfEvaluationException;
import com.sistema.evaluacion.models.dtos.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityNotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ConfigException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ExpiredJwtException.class ,BadTokenJwtException.class})
    public ResponseEntity<?> expiredJwtException(Exception e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NonUniqueUsernameException.class)
    public ResponseEntity<?> nonUniqueResultException(Exception e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NumberMaxQuestionOfEvaluationException.class)
    public ResponseEntity<?> numberMaxQuestionOfEvaluationException(Exception e){
        return new ResponseEntity<>(new MessageDto(e.getMessage()), HttpStatus.FORBIDDEN);
    }

}
