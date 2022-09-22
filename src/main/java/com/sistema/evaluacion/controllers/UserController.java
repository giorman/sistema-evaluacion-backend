package com.sistema.evaluacion.controllers;

import com.sistema.evaluacion.models.entities.User;
import com.sistema.evaluacion.services.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@Api(tags = "Controlador Usuario")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("user/save")
    @ApiOperation("Guardar un usuario")
    ResponseEntity<?> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping ("user")
    @ApiOperation("Actualizar un usuario")
    ResponseEntity<?> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.OK);
    }

    @GetMapping("user/{username}")
    @ApiOperation("Consultar un usuario")
    ResponseEntity<?> searchUser(@PathVariable String username){
        return new ResponseEntity<>(iUserService.searchUser(username), HttpStatus.OK);
    }

    @DeleteMapping("user/{id}")
    @ApiOperation("Eliminar un usuario")
    ResponseEntity<?> searchUser(@PathVariable Long id){
        iUserService.deleteUser(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
