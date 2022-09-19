package com.sistema.evaluacion.exceptions;

public class NonUniqueUsernameException extends RuntimeException{
    public NonUniqueUsernameException(String message) {
        super(message);
    }
}
