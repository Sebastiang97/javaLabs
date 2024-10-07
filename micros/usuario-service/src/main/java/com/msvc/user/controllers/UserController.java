package com.msvc.user.controllers;

import com.msvc.user.entity.User;
import com.msvc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> save (@RequestBody User usuarioReq){
        User usuario = userService.save(usuarioReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById (@PathVariable String userId){
        User usuario = userService.getById(userId);
        return ResponseEntity.ok().body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll (){
        List<User> usuarios = userService.getAll();
        return ResponseEntity.ok().body(usuarios);
    }
}
