package com.sistema.evaluacion.controllers;

import com.sistema.evaluacion.configuraciones.JwtUtils;
import com.sistema.evaluacion.models.JwtRequest;
import com.sistema.evaluacion.models.User;
import com.sistema.evaluacion.services.imp.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("api/")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("login")
    public ResponseEntity<?> generateToken(@RequestBody User user) throws Exception {

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(user.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }


    @GetMapping("/current-user")
    public ResponseEntity<?> getCurrentUser(Principal principal){
        return new ResponseEntity<>(this.userDetailsService.loadUserByUsername(principal.getName()), HttpStatus.OK) ;
    }
}
