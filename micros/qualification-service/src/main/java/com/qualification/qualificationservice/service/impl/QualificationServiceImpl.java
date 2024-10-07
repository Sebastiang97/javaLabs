package com.qualification.qualificationservice.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qualification.qualificationservice.entity.Qualification;
import com.qualification.qualificationservice.exceptions.ResourceNotFoundException;
import com.qualification.qualificationservice.repository.QualificationRepository;
import com.qualification.qualificationservice.service.QualificationService;

import java.util.List;
import java.util.UUID;

@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;

    @Override
    public Qualification save(Qualification qualification) {
        String id = UUID.randomUUID().toString();
        qualification.setQualificationId(id);
        return qualificationRepository.save(qualification);
    }

    @Override
    public List<Qualification> getAll() {
        return qualificationRepository.findAll();
    }

    @Override
    public Qualification getById(String userld) {
        return qualificationRepository.findById(userld)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el Id:" + userld));
    }

    @Override
    public List<Qualification> getByUserId(String userId) {
        return qualificationRepository.findByUserId(userId);
    }

    @Override
    public List<Qualification> getByHotelId(String hotelId) {
        return qualificationRepository.findByHotelId(hotelId);
    }
}
