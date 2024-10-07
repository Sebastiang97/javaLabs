package com.msvc.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private String userId;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "info")
    private String info;

    @Transient
    private List<Qualification> qualifications = new ArrayList<>();
    
}
