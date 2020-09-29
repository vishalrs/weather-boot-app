
package com.sogeti.weatherapp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "coord",
    "country",
    "population",
    "timezone",
    "sunrise",
    "sunset"
})
public class City {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("country")
    private String country;
    @JsonProperty("population")
    private Long population;
    @JsonProperty("timezone")
    private Long timezone;
    @JsonProperty("sunrise")
    private Long sunrise;
    @JsonProperty("sunset")
    private Long sunset;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("coord")
    public Coord getCoord() {
        return coord;
    }

    @JsonProperty("coord")
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("population")
    public Long getPopulation() {
        return population;
    }

    @JsonProperty("population")
    public void setPopulation(Long population) {
        this.population = population;
    }

    @JsonProperty("timezone")
    public Long getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("sunrise")
    public Long getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public Long getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("coord", coord).append("country", country).append("population", population).append("timezone", timezone).append("sunrise", sunrise).append("sunset", sunset).toString();
    }

}
