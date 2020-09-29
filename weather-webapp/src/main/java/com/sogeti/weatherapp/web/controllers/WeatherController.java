package com.sogeti.weatherapp.web.controllers;

import com.sogeti.weatherapp.common.api.IWeatherInfoApi;
import com.sogeti.weatherapp.common.model.*;
import com.sogeti.weatherapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class WeatherController {

    @Autowired
    IWeatherInfoApi weatherInfoService;

    @Autowired
    LocationRepository locationRepo;

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.key}")
    String apiKey;

    @GetMapping(path = "/weather")
    public String showWeather(@SessionAttribute(value="authUser", required = false) User authUser , @RequestParam(value = "city", defaultValue = "amsterdam") String city, Model model, HttpSession session) {

        Location location = locationRepo.findByCity(city.toLowerCase());
        String resourceUrl = "https://api.openweathermap.org/data/2.5/onecall?"
                + "lat=" + location.getLat() + "&lon="+ location.getLng()
                + "&units=metric&appid=" + apiKey;
        WeatherInfo weatherInfo = restTemplate.getForObject(resourceUrl, WeatherInfo.class);
        if(authUser == null){
            return "redirect:/login";
        }

        StandardWeatherInfo stdWeatherInfo = weatherInfoService.getWeatherInfo(city, weatherInfo);
        model.addAttribute("weather_info", stdWeatherInfo);
        model.addAttribute("authUser", authUser);
        if(authUser.getSubscription().equals("premium")){
            ForecastWeatherInfo forecastWeatherInfo = weatherInfoService.getForecastInfo(city, weatherInfo);
            System.out.println(forecastWeatherInfo);
            model.addAttribute("forecast_info", Optional.ofNullable(forecastWeatherInfo).map(o -> o.getForecastWeatherInfos()).orElse(null));
        }
        return "/weather";
    }

}
