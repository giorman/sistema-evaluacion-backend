package com.sistema.evaluacion.exceptions;

public class BadTokenJwtException extends RuntimeException{
    public BadTokenJwtException(String message) {
        super(message);
    }
}
