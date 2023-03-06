package com.example.projekt_s25663.model;

import com.example.projekt_s25663.model.enums.GenderType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "country_id")
    private int countryId;

}
