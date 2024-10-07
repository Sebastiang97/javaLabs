package com.msvc.hotel.hotelservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "info")
    private String info;

    @Column(name = "location")
    private String location;
    
}
