package com.sogeti.weatherapp.common.api;

import com.sogeti.weatherapp.common.model.ForecastWeatherInfo;
import com.sogeti.weatherapp.common.model.Location;
import com.sogeti.weatherapp.common.model.StandardWeatherInfo;
import com.sogeti.weatherapp.common.model.WeatherInfo;

public interface IWeatherInfoApi {

    StandardWeatherInfo getWeatherInfo(Location location);

    ForecastWeatherInfo getForecastInfo(Location location);
}
