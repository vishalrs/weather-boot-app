package com.sogeti.weatherapp.api.premium;

import com.sogeti.weatherapp.common.api.IWeatherInfoApi;
import com.sogeti.weatherapp.common.exceptions.InvalidLocationException;
import com.sogeti.weatherapp.common.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static com.sogeti.weatherapp.common.utils.DateTimeUtil.*;

@Service
public class PremiumWeatherInfoApi implements IWeatherInfoApi {

    private RestTemplate restTemplate;

    public PremiumWeatherInfoApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public StandardWeatherInfo getWeatherInfo(Location location) {
        Map<String, String> params = Map.of("lat", location.getLat(), "lng", location.getLng());
        if(!isLocationValid(location)){
            throw new InvalidLocationException("Location is invalid, cause" + location);
        }
        WeatherInfo weatherInfo = restTemplate.getForObject("", WeatherInfo.class, params);

        StandardWeatherInfo stdWeatherInfo = new StandardWeatherInfo();
        stdWeatherInfo.setCity(location.getCity());
        stdWeatherInfo.setCurrentDateTime(convertUTCToDateTime(weatherInfo.getCurrent().getDt(), weatherInfo.getTimezone()));
        stdWeatherInfo.setDescription(weatherInfo.getCurrent().getWeather().get(0).getDescription());
        stdWeatherInfo.setCurrentTemp(weatherInfo.getDaily().get(0).getTemp().getDay());
        stdWeatherInfo.setMinTemp(weatherInfo.getDaily().get(0).getTemp().getMin());
        stdWeatherInfo.setMaxTemp(weatherInfo.getDaily().get(0).getTemp().getMax());
        stdWeatherInfo.setHumidity(weatherInfo.getCurrent().getHumidity());
        stdWeatherInfo.setWindSpeed(weatherInfo.getCurrent().getWindSpeed());
        stdWeatherInfo.setSunrise(convertUTCToTime(weatherInfo.getCurrent().getSunrise(),weatherInfo.getTimezone()));
        stdWeatherInfo.setSunset(convertUTCToTime(weatherInfo.getCurrent().getSunset(),weatherInfo.getTimezone()));
        stdWeatherInfo.setLastCalcTime(weatherInfo.getCurrent().getDt());
        return stdWeatherInfo;
    }

    private boolean isLocationValid(Location location) {
        Double lat = Double.parseDouble(location.getLat());
        Double lng = Double.parseDouble(location.getLng());
        if(Math.abs(lat)<=90 && Math.abs(lng) <=180){
            return true;
        }
        return false;
    }

    @Override
    public ForecastWeatherInfo getForecastInfo(Location location) {
        Map<String, String> params = Map.of("lat", location.getLat(), "lng", location.getLng());
        WeatherInfo weatherInfo = restTemplate.getForObject("", WeatherInfo.class, params);

        ForecastWeatherInfo forecastWeatherInfo = new ForecastWeatherInfo();
        weatherInfo.getDaily().remove(0);
        for (Daily daily: weatherInfo.getDaily()) {
            StandardWeatherInfo stdWeatherInfo = new StandardWeatherInfo();
            stdWeatherInfo.setCity(location.getCity());
            stdWeatherInfo.setCurrentDateTime(convertUTCToDay(daily.getDt(), weatherInfo.getTimezone()));
            stdWeatherInfo.setDescription(daily.getWeather().get(0).getDescription());
            stdWeatherInfo.setCurrentTemp(daily.getTemp().getDay());
            stdWeatherInfo.setMinTemp(daily.getTemp().getMin());
            stdWeatherInfo.setMaxTemp(daily.getTemp().getMax());
            stdWeatherInfo.setHumidity(daily.getHumidity());
            stdWeatherInfo.setWindSpeed(daily.getWindSpeed());
            stdWeatherInfo.setSunrise(convertUTCToTime(daily.getSunrise(),weatherInfo.getTimezone()));
            stdWeatherInfo.setSunset(convertUTCToTime(daily.getSunset(),weatherInfo.getTimezone()));
            stdWeatherInfo.setLastCalcTime(daily.getDt());
            forecastWeatherInfo.getForecastWeatherInfos().add(stdWeatherInfo);
        }
        return forecastWeatherInfo;
    }


}
