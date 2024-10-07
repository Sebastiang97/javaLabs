package com.msvc.hotel.hotelservice.service;

import com.msvc.hotel.hotelservice.entity.Hotel;

import java.util.List;


public interface HotelService {

    Hotel save (Hotel hotel);

    List<Hotel> getAll ();

    Hotel getById (String userld);
}
