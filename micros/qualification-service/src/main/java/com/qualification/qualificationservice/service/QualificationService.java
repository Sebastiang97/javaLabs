package com.qualification.qualificationservice.service;


import java.util.List;

import com.qualification.qualificationservice.entity.Qualification;

public interface QualificationService {

    Qualification save (Qualification qualification);

    List<Qualification> getAll ();

    Qualification getById (String qualificationld);

    List<Qualification> getByUserId (String userId);

    List<Qualification> getByHotelId (String hotelId);
}
