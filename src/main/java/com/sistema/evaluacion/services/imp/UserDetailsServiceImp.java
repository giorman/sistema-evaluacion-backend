package com.sistema.evaluacion.services.imp;

import com.sistema.evaluacion.models.User;
import com.sistema.evaluacion.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.iUserRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return user;
    }

}