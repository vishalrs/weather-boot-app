package com.sogeti.weatherapp.autoconfigure.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="weather-app")
@Component

@Data
public class WeatherProperties {

    private String appId;
    private LangFeature langFeature;

    @Data
    public static class LangFeature{

        /**
            configures the language of data display
         */
        private String lang;

        /**
            indicator to show if the feature is enabled
         */
        private String isEnabled;
        private String units;
    }
}
