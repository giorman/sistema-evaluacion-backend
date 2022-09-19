package com.sistema.evaluacion.controllers;

import com.sistema.evaluacion.entities.JwtRequest;
import com.sistema.evaluacion.services.IAuthenticationService;
import com.sistema.evaluacion.services.impl.UserDetailsServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/v1/")
@Api(tags = "Controlador Autenticacion")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private IAuthenticationService iAuthenticationService;


    @PostMapping("login")
    @ApiOperation("Generador de un token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest){
        return iAuthenticationService.generateToken(jwtRequest);
    }

    @GetMapping("current-user")
    @ApiOperation("Consulta el usuario logueado")
    public ResponseEntity<?> getCurrentUser(Principal principal){
        return new ResponseEntity<>(this.userDetailsService.loadUserByUsername(principal.getName()), HttpStatus.OK) ;
    }
}
