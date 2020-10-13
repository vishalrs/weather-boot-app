package com.sogeti.weatherapp.web.controllers;

import com.sogeti.weatherapp.common.api.IWeatherInfoApi;
import com.sogeti.weatherapp.common.model.*;
import com.sogeti.weatherapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@RequestMapping("/web")
@ConditionalOnProperty(prefix = "weather-app", name = "lang-feature.is-enabled", havingValue = "false")
public class WeatherController {

    @Autowired
    IWeatherInfoApi weatherInfoService;

    @Autowired
    LocationRepository locationRepo;


    @GetMapping(path = "/weather")
    public String showWeather(@SessionAttribute(value="authUser", required = false) User authUser , @RequestParam(value = "city", defaultValue = "amsterdam") String city, Model model, HttpSession session) {
        Location location = locationRepo.findByCity(city.toLowerCase());
        if(authUser == null){
            return "redirect:/login";
        }
        StandardWeatherInfo stdWeatherInfo = weatherInfoService.getWeatherInfo(location);
        model.addAttribute("weather_info", stdWeatherInfo);
        model.addAttribute("authUser", authUser);
        if(authUser.getSubscription().equals("premium")){
            ForecastWeatherInfo forecastWeatherInfo = weatherInfoService.getForecastInfo(location);
            System.out.println(forecastWeatherInfo);
            model.addAttribute("forecast_info", Optional.ofNullable(forecastWeatherInfo).map(o -> o.getForecastWeatherInfos()).orElse(null));
        }
        return "weather";
    }

}
