package com.sogeti.weatherapp.autoconfigure;

import com.sogeti.weatherapp.api.premium.PremiumWeatherInfoApi;
import com.sogeti.weatherapp.autoconfigure.props.WeatherProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import com.sogeti.weatherapp.autoconfigure.handler.RestTemplateResponseErrorHandler;

@Configuration
@ConditionalOnClass(PremiumWeatherInfoApi.class)
public class PremiumWeatherApiAutoConfig {


    @Bean
    @ConditionalOnMissingBean
    public PremiumWeatherInfoApi getPremiumWeatherComponent(RestTemplate restTemplate){
        return new PremiumWeatherInfoApi(restTemplate);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "weather-app", name = "lang-feature.is-enabled", havingValue = "false")
    public RestTemplate getDefaultRestTemplate(RestTemplateBuilder restBuilder, WeatherProperties props){
        UriComponentsBuilder uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.openweathermap.org")
                .path("/data/2.5/onecall")
                .query("appid=" + props.getAppId() + "&units=metric&lat={lat}&lon={lng}");
        DefaultUriBuilderFactory fact = new DefaultUriBuilderFactory(uriComponents);
        return new RestTemplateBuilder()
        .uriTemplateHandler(fact)
        .errorHandler(new RestTemplateResponseErrorHandler())
        .build();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "weather-app", name = "lang-feature.is-enabled", havingValue = "true")
    public RestTemplate getRestTemplateWithLangFeature(RestTemplateBuilder restBuilder, WeatherProperties props){
        UriComponentsBuilder uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.openweathermap.org")
                .path("/data/2.5/onecall")
                .query("appid=" + props.getAppId() +
                        "&units=" + props.getLangFeature().getUnits() +
                        "&lang=" + props.getLangFeature().getLang() +
                        "&lat={lat}&lon={lng}");
        DefaultUriBuilderFactory fact = new DefaultUriBuilderFactory(uriComponents);
        return new RestTemplateBuilder()
                .uriTemplateHandler(fact)
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }
}
