package com.sistema.evaluacion.services;

import com.sistema.evaluacion.models.dtos.JwtRequestDto;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationService {
    ResponseEntity<?> generateToken(JwtRequestDto jwtRequestDto);
    void authentication(String username,String password) throws Exception;
}
