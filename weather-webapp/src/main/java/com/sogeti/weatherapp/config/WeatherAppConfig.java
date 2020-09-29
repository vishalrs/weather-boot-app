package com.sogeti.weatherapp.config;

import com.sogeti.weatherapp.api.standard.StandardWeatherInfoApi;
import com.sogeti.weatherapp.common.api.IWeatherInfoApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherAppConfig {

    @Bean
    public IWeatherInfoApi getStandardWeatherInfoApi(){
        return new StandardWeatherInfoApi();
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder restBuilder){
        return restBuilder.build();
    }
}
