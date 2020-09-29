
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
    "lat",
    "lon",
    "timezone",
    "timezone_offset",
    "current",
    "minutely",
    "hourly",
    "daily"
})
public class WeatherInfo implements Serializable
{

    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("timezone_offset")
    private Long timezoneOffset;
    @JsonProperty("current")
    private Current current;
    @JsonProperty("minutely")
    private List<Minutely> minutely = new ArrayList<Minutely>();
    @JsonProperty("hourly")
    private List<Hourly> hourly = new ArrayList<Hourly>();
    @JsonProperty("daily")
    private List<Daily> daily = new ArrayList<Daily>();
    private final static long serialVersionUID = -3395128430836345735L;

    @JsonProperty("lat")
    public Double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Double lat) {
        this.lat = lat;
    }

    @JsonProperty("lon")
    public Double getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(Double lon) {
        this.lon = lon;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("timezone_offset")
    public Long getTimezoneOffset() {
        return timezoneOffset;
    }

    @JsonProperty("timezone_offset")
    public void setTimezoneOffset(Long timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    @JsonProperty("current")
    public Current getCurrent() {
        return current;
    }

    @JsonProperty("current")
    public void setCurrent(Current current) {
        this.current = current;
    }

    @JsonProperty("minutely")
    public List<Minutely> getMinutely() {
        return minutely;
    }

    @JsonProperty("minutely")
    public void setMinutely(List<Minutely> minutely) {
        this.minutely = minutely;
    }

    @JsonProperty("hourly")
    public List<Hourly> getHourly() {
        return hourly;
    }

    @JsonProperty("hourly")
    public void setHourly(List<Hourly> hourly) {
        this.hourly = hourly;
    }

    @JsonProperty("daily")
    public List<Daily> getDaily() {
        return daily;
    }

    @JsonProperty("daily")
    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("lat", lat).append("lon", lon).append("timezone", timezone).append("timezoneOffset", timezoneOffset).append("current", current).append("minutely", minutely).append("hourly", hourly).append("daily", daily).toString();
    }

}
