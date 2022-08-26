package com.sistema.evaluacion.config.exceptions;

public class BadTokenJwtException extends RuntimeException{
    public BadTokenJwtException(String message) {
        super(message);
    }
}
