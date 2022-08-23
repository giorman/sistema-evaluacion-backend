package com.sistema.evaluacion.controllers;

import com.sistema.evaluacion.models.User;
import com.sistema.evaluacion.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user/")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("save")
    ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("get/{username}")
    ResponseEntity<?> searchUser(@PathVariable String username){

        return new ResponseEntity<>(iUserService.searchUser(username), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> searchUser(@PathVariable Long id){
        iUserService.deleteUser(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
