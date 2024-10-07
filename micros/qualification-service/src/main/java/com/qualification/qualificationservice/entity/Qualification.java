package com.qualification.qualificationservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Qualification")
public class Qualification {

    @Id
    private String qualificationId;
    private String userId;
    private String hotelId;
    private int qualification;
    private String info;

}
