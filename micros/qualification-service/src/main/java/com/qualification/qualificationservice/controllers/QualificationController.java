package com.qualification.qualificationservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.qualification.qualificationservice.entity.Qualification;
import com.qualification.qualificationservice.service.QualificationService;

import java.util.List;

@RestController
@RequestMapping("/qualifications")
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;

    @PostMapping
    public ResponseEntity<Qualification> save (@RequestBody Qualification usuarioReq){
        Qualification usuario = qualificationService.save(usuarioReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/{qualificationId}")
    public ResponseEntity<Qualification> getById (@PathVariable String qualificationId){
        Qualification qualification = qualificationService.getById(qualificationId);
        return ResponseEntity.ok().body(qualification);
    }

    @GetMapping
    public ResponseEntity<List<Qualification>> getAll (){
        List<Qualification> qualifications = qualificationService.getAll();
        return ResponseEntity.ok().body(qualifications);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Qualification>> getByUserId (@PathVariable String userId){
        List<Qualification> qualifications = qualificationService.getByUserId(userId);
        return ResponseEntity.ok().body(qualifications);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Qualification>> getByHotelId (@PathVariable String hotelId){
        List<Qualification> qualifications = qualificationService.getByHotelId(hotelId);
        return ResponseEntity.ok().body(qualifications);
    }
}
