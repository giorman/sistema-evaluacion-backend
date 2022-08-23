package com.sistema.evaluacion.controllers;

import com.sistema.evaluacion.configuraciones.JwtUtils;
import com.sistema.evaluacion.models.JwtRequest;
import com.sistema.evaluacion.models.JwtResponse;
import com.sistema.evaluacion.services.IAuthenticationService;
import com.sistema.evaluacion.services.imp.UserDetailsServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImp userDetailsService;

    @Autowired
    private IAuthenticationService iAuthenticationService;


    @PostMapping("login")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return iAuthenticationService.generateToken(jwtRequest);
    }


    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser(Principal principal){
        return new ResponseEntity<>(this.userDetailsService.loadUserByUsername(principal.getName()), HttpStatus.OK) ;
    }
}
