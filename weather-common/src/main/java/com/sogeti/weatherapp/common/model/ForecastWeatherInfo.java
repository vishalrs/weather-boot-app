package com.sogeti.weatherapp.common.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ForecastWeatherInfo {

    private List<StandardWeatherInfo> forecastWeatherInfos = new ArrayList<>();
}
