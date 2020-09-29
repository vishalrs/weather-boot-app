
package com.sogeti.weatherapp.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "1h"
})
public class Rain implements Serializable
{

    @JsonProperty("1h")
    private Double _1h;
    private final static long serialVersionUID = -1394812782032180234L;

    @JsonProperty("1h")
    public Double get1h() {
        return _1h;
    }

    @JsonProperty("1h")
    public void set1h(Double _1h) {
        this._1h = _1h;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("_1h", _1h).toString();
    }

}
