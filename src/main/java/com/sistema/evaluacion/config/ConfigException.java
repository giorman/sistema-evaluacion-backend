package com.sistema.evaluacion.config;

import com.sistema.evaluacion.config.exceptions.BadTokenJwtException;
import com.sistema.evaluacion.config.exceptions.ExpiredJwtException;
import com.sistema.evaluacion.config.exceptions.NonUniqueUsernameException;
import com.sistema.evaluacion.entities.Message;
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

    @ExceptionHandler({ExpiredJwtException.class ,BadTokenJwtException.class})
    public ResponseEntity<?> expiredJwtException(Exception e){
        return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NonUniqueUsernameException.class)
    public ResponseEntity<?> nonUniqueResultException(Exception e){
        return new ResponseEntity<>(new Message(e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
