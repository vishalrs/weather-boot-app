package com.sogeti.weatherapp.autoconfigure;

import com.sogeti.weatherapp.api.premium.PremiumWeatherInfoApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(PremiumWeatherInfoApi.class)
public class PremiumWeatherApiAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public PremiumWeatherInfoApi getPremiumWeatherComponent(){
        return new PremiumWeatherInfoApi();
    }
}
