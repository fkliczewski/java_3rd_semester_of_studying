package com.example.test_kolokwium_2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "addres")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String city;
    @Column(name = "postal_code")
    String postalCode;
    String street;

}
