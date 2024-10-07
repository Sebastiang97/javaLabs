package com.msvc.hotel.hotelservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.msvc.hotel.hotelservice.entity.Hotel;
import com.msvc.hotel.hotelservice.service.HotelService;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> save (@RequestBody Hotel hotelReq){
        Hotel hotel = hotelService.save(hotelReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getById (@PathVariable String hotelId){
        Hotel hotel = hotelService.getById(hotelId);
        return ResponseEntity.ok().body(hotel);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll (){
        List<Hotel> hotels = hotelService.getAll();
        return ResponseEntity.ok().body(hotels);
    }
}
