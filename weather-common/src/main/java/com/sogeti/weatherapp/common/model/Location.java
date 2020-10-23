package com.sogeti.weatherapp.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "locations")
@NoArgsConstructor
public class Location {

    public Location(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

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
