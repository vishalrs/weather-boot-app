package com.sogeti.weatherapp.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class WeatherHealthCheck implements HealthIndicator {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Health health() {
        Map<String, String> params = Map.of("lat", "52.35", "lng", "4.9166");
        ResponseEntity<String> res = restTemplate.getForEntity("", String.class, params);
        if (res.getStatusCode().equals(HttpStatus.OK))
            return Health.up().build();
        else
            return Health.down().withDetail("error", res.toString()).build();
    }
}