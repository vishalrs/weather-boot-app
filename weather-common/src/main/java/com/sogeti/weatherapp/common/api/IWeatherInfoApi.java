package com.sogeti.weatherapp.common.api;

import com.sogeti.weatherapp.common.model.ForecastWeatherInfo;
import com.sogeti.weatherapp.common.model.StandardWeatherInfo;
import com.sogeti.weatherapp.common.model.WeatherInfo;

public interface IWeatherInfoApi {

    StandardWeatherInfo getWeatherInfo(String city, WeatherInfo weatherInfo);

    ForecastWeatherInfo getForecastInfo(String city, WeatherInfo weatherInfo);
}
