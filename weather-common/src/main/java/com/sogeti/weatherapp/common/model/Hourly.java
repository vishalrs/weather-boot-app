
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
    "temp",
    "feels_like",
    "pressure",
    "humidity",
    "dew_point",
    "clouds",
    "visibility",
    "wind_speed",
    "wind_deg",
    "weather",
    "pop",
    "rain"
})
public class Hourly implements Serializable
{

    @JsonProperty("dt")
    private Long dt;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("feels_like")
    private Double feelsLike;
    @JsonProperty("pressure")
    private Long pressure;
    @JsonProperty("humidity")
    private Long humidity;
    @JsonProperty("dew_point")
    private Double dewPoint;
    @JsonProperty("clouds")
    private Long clouds;
    @JsonProperty("visibility")
    private Long visibility;
    @JsonProperty("wind_speed")
    private Double windSpeed;
    @JsonProperty("wind_deg")
    private Long windDeg;
    @JsonProperty("weather")
    private List<Weather_> weather = new ArrayList<Weather_>();
    @JsonProperty("pop")
    private Long pop;
    @JsonProperty("rain")
    private Rain rain;
    private final static long serialVersionUID = 4162940013926436043L;

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
    }

    @JsonProperty("temp")
    public Double getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public Double getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("feels_like")
    public void setFeelsLike(Double feelsLike) {
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

    @JsonProperty("clouds")
    public Long getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Long clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("visibility")
    public Long getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Long visibility) {
        this.visibility = visibility;
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
    public List<Weather_> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather_> weather) {
        this.weather = weather;
    }

    @JsonProperty("pop")
    public Long getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(Long pop) {
        this.pop = pop;
    }

    @JsonProperty("rain")
    public Rain getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dt", dt).append("temp", temp).append("feelsLike", feelsLike).append("pressure", pressure).append("humidity", humidity).append("dewPoint", dewPoint).append("clouds", clouds).append("visibility", visibility).append("windSpeed", windSpeed).append("windDeg", windDeg).append("weather", weather).append("pop", pop).append("rain", rain).toString();
    }

}
