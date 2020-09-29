package com.sogeti.weatherapp.autoconfigure;

import com.sogeti.weatherapp.api.standard.StandardWeatherInfoApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(StandardWeatherInfoApi.class)
public class StandardWeatherApiAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public StandardWeatherInfoApi getStandardWeatherComponent(){
        return new StandardWeatherInfoApi();
    }


}
