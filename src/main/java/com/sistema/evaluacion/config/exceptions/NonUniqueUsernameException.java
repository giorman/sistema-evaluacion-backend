package com.sistema.evaluacion.config.exceptions;

public class NonUniqueUsernameException extends RuntimeException{
    public NonUniqueUsernameException(String message) {
        super(message);
    }
}
