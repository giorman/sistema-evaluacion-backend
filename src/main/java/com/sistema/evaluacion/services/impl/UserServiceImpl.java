package com.sistema.evaluacion.services.impl;

import com.sistema.evaluacion.exceptions.NonUniqueUsernameException;
import com.sistema.evaluacion.entities.Rol;
import com.sistema.evaluacion.entities.User;
import com.sistema.evaluacion.repositories.IRolRepository;
import com.sistema.evaluacion.repositories.IUserRepository;
import com.sistema.evaluacion.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRolRepository iRolRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user){
        User userResult = iUserRepository.findByUsername(user.getUsername());
        if (userResult != null){
             throw new NonUniqueUsernameException("el nombre de usuario ya esta en uso");
        }
            Rol rol = new Rol();
            rol.setId(2L);
            Set<Rol> roles = new HashSet<>();
            roles.add(rol);
            user.setRols(roles);
            user.setEnable(true);
            user.setProfile("default.png");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return iUserRepository.save(user);
    }

    @Override
    public User searchUser(String username) {
        User userResult=iUserRepository.findByUsername(username);
        if (userResult == null) {
            throw new EntityNotFoundException("El usuario no existe");
        }
        return userResult;
    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> userOptional= iUserRepository.findById(id);
        if (!userOptional.isPresent()){
            throw new EntityNotFoundException("El usuario no existe");
        }
     iUserRepository.deleteById(id);
    }
}
