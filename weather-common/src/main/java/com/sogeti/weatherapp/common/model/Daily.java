
package com.sogeti.weatherapp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "sunrise",
    "sunset",
    "temp",
    "feels_like",
    "pressure",
    "humidity",
    "dew_point",
    "wind_speed",
    "wind_deg",
    "weather",
    "clouds",
    "pop",
    "rain",
    "uvi"
})
public class Daily implements Serializable
{

    @JsonProperty("dt")
    private Long dt;
    @JsonProperty("sunrise")
    private Long sunrise;
    @JsonProperty("sunset")
    private Long sunset;
    @JsonProperty("temp")
    private Temp temp;
    @JsonProperty("feels_like")
    private FeelsLike feelsLike;
    @JsonProperty("pressure")
    private Long pressure;
    @JsonProperty("humidity")
    private Long humidity;
    @JsonProperty("dew_point")
    private Double dewPoint;
    @JsonProperty("wind_speed")
    private Double windSpeed;
    @JsonProperty("wind_deg")
    private Long windDeg;
    @JsonProperty("weather")
    private List<Weather__> weather = new ArrayList<Weather__>();
    @JsonProperty("clouds")
    private Long clouds;
    @JsonProperty("pop")
    private Double pop;
    @JsonProperty("rain")
    private Double rain;
    @JsonProperty("uvi")
    private Double uvi;
    private final static long serialVersionUID = 6101477194542732587L;

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
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

    @JsonProperty("temp")
    public Temp getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public FeelsLike getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("feels_like")
    public void setFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
    }

    @JsonProperty("pressure")
    public Long getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public Long getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("dew_point")
    public Double getDewPoint() {
        return dewPoint;
    }

    @JsonProperty("dew_point")
    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    @JsonProperty("wind_speed")
    public Double getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("wind_speed")
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("wind_deg")
    public Long getWindDeg() {
        return windDeg;
    }

    @JsonProperty("wind_deg")
    public void setWindDeg(Long windDeg) {
        this.windDeg = windDeg;
    }

    @JsonProperty("weather")
    public List<Weather__> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather__> weather) {
        this.weather = weather;
    }

    @JsonProperty("clouds")
    public Long getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Long clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("pop")
    public Double getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(Double pop) {
        this.pop = pop;
    }

    @JsonProperty("rain")
    public Double getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(Double rain) {
        this.rain = rain;
    }

    @JsonProperty("uvi")
    public Double getUvi() {
        return uvi;
    }

    @JsonProperty("uvi")
    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dt", dt).append("sunrise", sunrise).append("sunset", sunset).append("temp", temp).append("feelsLike", feelsLike).append("pressure", pressure).append("humidity", humidity).append("dewPoint", dewPoint).append("windSpeed", windSpeed).append("windDeg", windDeg).append("weather", weather).append("clouds", clouds).append("pop", pop).append("rain", rain).append("uvi", uvi).toString();
    }

}
