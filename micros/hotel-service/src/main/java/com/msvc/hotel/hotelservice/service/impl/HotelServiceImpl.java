package com.msvc.hotel.hotelservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.hotel.hotelservice.entity.Hotel;
import com.msvc.hotel.hotelservice.exceptions.ResourceNotFoundException;
import com.msvc.hotel.hotelservice.repository.HotelRepository;
import com.msvc.hotel.hotelservice.service.HotelService;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel save(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(String hotelld) {
        return hotelRepository.findById(hotelld)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el Id:" + hotelld));
    }
}
