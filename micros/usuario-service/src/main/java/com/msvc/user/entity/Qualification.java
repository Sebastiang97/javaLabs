package com.msvc.user.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Qualification {
    private String qualificationId;
    private String userId;
    private String hotelId;
    private int qualification;
    private String info;
}
