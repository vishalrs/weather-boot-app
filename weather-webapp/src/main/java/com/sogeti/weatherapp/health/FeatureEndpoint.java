package com.sogeti.weatherapp.health;

import com.sogeti.weatherapp.autoconfigure.props.WeatherProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id="features")
@Component
public class FeatureEndpoint {

    @Autowired
    WeatherProperties props;

    @ReadOperation
    public WeatherProperties.LangFeature getFeatures(){
        return props.getLangFeature();
    }
}
