
package com.sogeti.weatherapp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temp",
    "feels_like",
    "temp_min",
    "temp_max",
    "pressure",
    "sea_level",
    "grnd_level",
    "humidity",
    "temp_kf"
})
public class Main {

    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("feels_like")
    private Double feelsLike;
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("temp_max")
    private Double tempMax;
    @JsonProperty("pressure")
    private Long pressure;
    @JsonProperty("sea_level")
    private Long seaLevel;
    @JsonProperty("grnd_level")
    private Long grndLevel;
    @JsonProperty("humidity")
    private Long humidity;
    @JsonProperty("temp_kf")
    private Long tempKf;

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

    @JsonProperty("temp_min")
    public Double getTempMin() {
        return tempMin;
    }

    @JsonProperty("temp_min")
    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    @JsonProperty("temp_max")
    public Double getTempMax() {
        return tempMax;
    }

    @JsonProperty("temp_max")
    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    @JsonProperty("pressure")
    public Long getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("sea_level")
    public Long getSeaLevel() {
        return seaLevel;
    }

    @JsonProperty("sea_level")
    public void setSeaLevel(Long seaLevel) {
        this.seaLevel = seaLevel;
    }

    @JsonProperty("grnd_level")
    public Long getGrndLevel() {
        return grndLevel;
    }

    @JsonProperty("grnd_level")
    public void setGrndLevel(Long grndLevel) {
        this.grndLevel = grndLevel;
    }

    @JsonProperty("humidity")
    public Long getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("temp_kf")
    public Long getTempKf() {
        return tempKf;
    }

    @JsonProperty("temp_kf")
    public void setTempKf(Long tempKf) {
        this.tempKf = tempKf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("temp", temp).append("feelsLike", feelsLike).append("tempMin", tempMin).append("tempMax", tempMax).append("pressure", pressure).append("seaLevel", seaLevel).append("grndLevel", grndLevel).append("humidity", humidity).append("tempKf", tempKf).toString();
    }

}
