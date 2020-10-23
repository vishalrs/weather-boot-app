package com.sogeti.weatherapp.service.premium.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sogeti.weatherapp.api.premium.PremiumWeatherInfoApi;
import com.sogeti.weatherapp.common.exceptions.InvalidLocationException;
import com.sogeti.weatherapp.common.model.Location;
import com.sogeti.weatherapp.common.model.StandardWeatherInfo;
import com.sogeti.weatherapp.common.model.WeatherInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PremiumWeatherApiTests {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    PremiumWeatherInfoApi weatherInfoApi;

    ObjectMapper mapper = new ObjectMapper();
    @Test
    void testGetCurrentWeatherApiValidResponse() throws IOException {
        File file = ResourceUtils.getFile(this.getClass().getResource("/weather.json"));
        Location location = new Location("80.6", "110.8");
        when(restTemplate.getForObject("", WeatherInfo.class,
                Map.of("lat", location.getLat(), "lng", location.getLng()))).thenReturn(mapper.readValue(file, WeatherInfo.class));
        StandardWeatherInfo weatherInfo = weatherInfoApi.getWeatherInfo(location);
        assertNotNull(weatherInfo);
    }

    @Test
    void testGetCurrentWeatherWithInvalidLocation() throws IOException {
        Location location = new Location("180.6", "110.8");
        assertThrows(InvalidLocationException.class, ()->{
            StandardWeatherInfo weatherInfo = weatherInfoApi.getWeatherInfo(location);
        });
    }
}
