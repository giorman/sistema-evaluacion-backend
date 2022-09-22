package com.sistema.evaluacion.services;

import com.sistema.evaluacion.models.entities.User;


public interface IUserService {
    User saveUser(User user);

    void updateUser(User user);

    User searchUser(String username);

    void deleteUser(Long id);
}
