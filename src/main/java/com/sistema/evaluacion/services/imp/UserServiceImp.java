package com.sistema.evaluacion.services.imp;

import com.sistema.evaluacion.models.Rol;
import com.sistema.evaluacion.models.User;
import com.sistema.evaluacion.repositories.IRolRepository;
import com.sistema.evaluacion.repositories.IUserRepository;
import com.sistema.evaluacion.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRolRepository iRolRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user){
        User userLocal = iUserRepository.findByUsername(user.getUsername());
        if (userLocal != null){
            System.out.println("el usuario ya existe");
//             throw new Exception("el usuario ya existe");
        }else{
            Rol rol = new Rol();
            rol.setId(2L);
            Set<Rol> roles = new HashSet<>();
            roles.add(rol);
            user.setRols(roles);
            user.setEnable(true);
            user.setProfile("default.png");
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userLocal= iUserRepository.save(user);
        }
        return userLocal;
    }

    @Override
    public User searchUser(String username) {
        return iUserRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long id) {
     iUserRepository.deleteById(id);

    }
}
