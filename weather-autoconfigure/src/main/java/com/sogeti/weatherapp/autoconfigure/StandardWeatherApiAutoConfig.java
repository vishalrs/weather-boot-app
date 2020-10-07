package com.sogeti.weatherapp.autoconfigure;

import com.sogeti.weatherapp.api.standard.StandardWeatherInfoApi;
import com.sogeti.weatherapp.autoconfigure.props.WeatherProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;
import com.sogeti.weatherapp.autoconfigure.handler.RestTemplateResponseErrorHandler;

@Configuration
@ConditionalOnClass(StandardWeatherInfoApi.class)
public class StandardWeatherApiAutoConfig {

    @Autowired
    WeatherProperties props;

    @Bean
    @ConditionalOnMissingBean
    public StandardWeatherInfoApi getStandardWeatherComponent(){
        return new StandardWeatherInfoApi();
    }

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate getDefaultRestTemplate(RestTemplateBuilder restBuilder){
        UriComponentsBuilder uriComponents = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("api.openweathermap.org")
                .path("/data/2.5/onecall")
                .query("appid=" + props.getAppId() + "&units=metric&lat={lat}&lon={lng}");
        DefaultUriBuilderFactory fact = new DefaultUriBuilderFactory(uriComponents);
        return new RestTemplateBuilder()
                    .errorHandler(new RestTemplateResponseErrorHandler())
                    .uriTemplateHandler(fact)
                    .build();
    }
}
