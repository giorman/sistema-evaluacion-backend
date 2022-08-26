package com.sistema.evaluacion.services.impl;

import com.sistema.evaluacion.security.JwtUtils;
import com.sistema.evaluacion.models.JwtRequest;
import com.sistema.evaluacion.models.JwtResponse;
import com.sistema.evaluacion.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseEntity<?> generateToken(JwtRequest jwtRequest) {
        try{
            authentication(jwtRequest.getUsername(),jwtRequest.getPassword());
        }catch (Exception exception){
            throw new EntityNotFoundException("Credenciales invalidas");
        }
        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
    }

    @Override
    public void authentication(String username, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("USUARIO DESHABILITADO " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Credenciales invalidas " + e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
