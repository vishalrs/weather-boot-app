
package com.sogeti.weatherapp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "day",
    "min",
    "max",
    "night",
    "eve",
    "morn"
})
public class Temp implements Serializable
{

    @JsonProperty("day")
    private Double day;
    @JsonProperty("min")
    private Double min;
    @JsonProperty("max")
    private Double max;
    @JsonProperty("night")
    private Double night;
    @JsonProperty("eve")
    private Double eve;
    @JsonProperty("morn")
    private Double morn;
    private final static long serialVersionUID = -5216673378985091156L;

    @JsonProperty("day")
    public Double getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(Double day) {
        this.day = day;
    }

    @JsonProperty("min")
    public Double getMin() {
        return min;
    }

    @JsonProperty("min")
    public void setMin(Double min) {
        this.min = min;
    }

    @JsonProperty("max")
    public Double getMax() {
        return max;
    }

    @JsonProperty("max")
    public void setMax(Double max) {
        this.max = max;
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
        return new ToStringBuilder(this).append("day", day).append("min", min).append("max", max).append("night", night).append("eve", eve).append("morn", morn).toString();
    }

}
