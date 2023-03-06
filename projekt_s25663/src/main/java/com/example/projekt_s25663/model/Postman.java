package com.example.projekt_s25663.model;

import com.example.projekt_s25663.model.enums.GenderType;
import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@Table(name = "postman")
public class Postman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;

    @Column(name = "region_id")
    private long regionId;

    private  String addres;
    private  String email;

    @Column(name = "job_position_id")
    private int jobPositionId;

    @Enumerated(EnumType.STRING)
    private GenderType gender;
}
