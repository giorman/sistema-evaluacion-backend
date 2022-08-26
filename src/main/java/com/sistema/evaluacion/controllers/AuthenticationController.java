package com.sistema.evaluacion.controllers;

import com.sistema.evaluacion.entities.JwtRequest;
import com.sistema.evaluacion.services.IAuthenticationService;
import com.sistema.evaluacion.services.impl.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private IAuthenticationService iAuthenticationService;


    @PostMapping("login")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest){
        return iAuthenticationService.generateToken(jwtRequest);
    }

    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser(Principal principal){
        return new ResponseEntity<>(this.userDetailsService.loadUserByUsername(principal.getName()), HttpStatus.OK) ;
    }
}
