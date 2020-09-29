
package com.sogeti.weatherapp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "main",
    "weather",
    "clouds",
    "wind",
    "visibility",
    "pop",
    "sys",
    "dt_txt",
    "rain"
})
public class List {

    @JsonProperty("dt")
    private Long dt;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private java.util.List<Weather> weather = new ArrayList<Weather>();
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("visibility")
    private Long visibility;
    @JsonProperty("pop")
    private Long pop;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("dt_txt")
    private String dtTxt;
    @JsonProperty("rain")
    private Rain rain;

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
    }

    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    @JsonProperty("weather")
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @JsonProperty("visibility")
    public Long getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(Long visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("pop")
    public Long getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(Long pop) {
        this.pop = pop;
    }

    @JsonProperty("sys")
    public Sys getSys() {
        return sys;
    }

    @JsonProperty("sys")
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    @JsonProperty("dt_txt")
    public String getDtTxt() {
        return dtTxt;
    }

    @JsonProperty("dt_txt")
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
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
        return new ToStringBuilder(this).append("dt", dt).append("main", main).append("weather", weather).append("clouds", clouds).append("wind", wind).append("visibility", visibility).append("pop", pop).append("sys", sys).append("dtTxt", dtTxt).append("rain", rain).toString();
    }

}
