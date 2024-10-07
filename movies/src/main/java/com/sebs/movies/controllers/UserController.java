package com.sebs.movies.controllers;

import com.sebs.movies.documents.Users;
import com.sebs.movies.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Users user){
        try {
            Users userSave = userRepository.save(user);
            return new ResponseEntity<Users>(userSave, HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        try {
            List<Users> usersList= userRepository.findAll();
            return new ResponseEntity<List<Users>>(usersList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody Users user){
        try {
            Users usersList= userRepository.save(user);
            return new ResponseEntity<Users>(usersList, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        try {
            int[] numbers = {1,2,3,45};
            userRepository.deleteById(id);
            HashMap<String, String> responseDelete = new HashMap<String, String>();

            responseDelete.put("status", "ok");
            responseDelete.put("user", "eliminate");
            return new ResponseEntity<HashMap<String, String>>(responseDelete, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
