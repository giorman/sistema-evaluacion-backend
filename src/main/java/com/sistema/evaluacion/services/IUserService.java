package com.sistema.evaluacion.services;

import com.sistema.evaluacion.models.User;


public interface IUserService {
    User saveUser(User user)throws Exception;

    User searchUser(String username);

    void deleteUser(Long id);
}
