package com.sogeti.weatherapp.common.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String lat;

    private String lng;

    private String country;

    @Column(name = "country_code")
    private String countryCode;

}
