
package com.sogeti.weatherapp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "day",
    "night",
    "eve",
    "morn"
})
public class FeelsLike implements Serializable
{

    @JsonProperty("day")
    private Double day;
    @JsonProperty("night")
    private Double night;
    @JsonProperty("eve")
    private Double eve;
    @JsonProperty("morn")
    private Double morn;
    private final static long serialVersionUID = -2684921768749505297L;

    @JsonProperty("day")
    public Double getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Double day) {
        this.day = day;
    }

    @JsonProperty("night")
    public Double getNight() {
        return night;
    }

    @JsonProperty("night")
    public void setNight(Double night) {
        this.night = night;
    }

    @JsonProperty("eve")
    public Double getEve() {
        return eve;
    }

    @JsonProperty("eve")
    public void setEve(Double eve) {
        this.eve = eve;
    }

    @JsonProperty("morn")
    public Double getMorn() {
        return morn;
    }

    @JsonProperty("morn")
    public void setMorn(Double morn) {
        this.morn = morn;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("day", day).append("night", night).append("eve", eve).append("morn", morn).toString();
    }

}
