package com.sistema.evaluacion.services;

import com.sistema.evaluacion.models.JwtRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationService {
    ResponseEntity<?> generateToken(JwtRequest jwtRequest) throws Exception;
    void authentication(String username,String password) throws Exception;
}