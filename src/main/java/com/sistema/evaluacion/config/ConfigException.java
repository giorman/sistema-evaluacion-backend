package com.sistema.evaluacion.config;

import com.sistema.evaluacion.config.exceptions.BadTokenJwtException;
import com.sistema.evaluacion.config.exceptions.ExpiredJwtException;
import com.sistema.evaluacion.models.Message;
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
        return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadTokenJwtException.class)
    public ResponseEntity<?> badTokenJwtException(Exception e){
        return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<?> expiredjwtException(Exception e){
        return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.BAD_GATEWAY);
    }

}
