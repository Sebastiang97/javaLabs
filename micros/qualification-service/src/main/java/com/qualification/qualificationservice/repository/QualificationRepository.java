package com.qualification.qualificationservice.repository;

import com.qualification.qualificationservice.entity.Qualification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QualificationRepository extends MongoRepository<Qualification, String> {


    List<Qualification> findByUserId(String userId);

    List<Qualification> findByHotelId(String hotelId);
}
