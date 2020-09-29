package com.sogeti.weatherapp.common.model;

import lombok.Data;

@Data
public class StandardWeatherInfo {

    private String city;

    private Double currentTemp;

    private String description;

    private Double minTemp;

    private Double maxTemp;

    private Long humidity;

    private Double windSpeed;

    private Long lastCalcTime;

    private String currentDateTime;

    private String sunrise;

    private String sunset;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getCurrentTemp() {
        return currentTemp;
    }

    public void setCurrentTemp(Double currentTemp) {
        this.currentTemp = currentTemp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getLastCalcTime() {
        return lastCalcTime;
    }

    public void setLastCalcTime(Long lastCalcTime) {
        this.lastCalcTime = System.currentTimeMillis();
    }

}
