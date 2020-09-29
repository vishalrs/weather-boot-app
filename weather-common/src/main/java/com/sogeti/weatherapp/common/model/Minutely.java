
package com.sogeti.weatherapp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dt",
    "precipitation"
})
public class Minutely implements Serializable
{

    @JsonProperty("dt")
    private Long dt;
    @JsonProperty("precipitation")
    private Long precipitation;
    private final static long serialVersionUID = -6371149976980237797L;

    @JsonProperty("dt")
    public Long getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Long dt) {
        this.dt = dt;
    }

    @JsonProperty("precipitation")
    public Long getPrecipitation() {
        return precipitation;
    }

    @JsonProperty("precipitation")
    public void setPrecipitation(Long precipitation) {
        this.precipitation = precipitation;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dt", dt).append("precipitation", precipitation).toString();
    }

}
