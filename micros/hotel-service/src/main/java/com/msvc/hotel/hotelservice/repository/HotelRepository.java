package com.msvc.hotel.hotelservice.repository;

import com.msvc.hotel.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
    
}
