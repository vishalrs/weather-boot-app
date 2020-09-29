package com.sogeti.weatherapp.api.premium;

import com.sogeti.weatherapp.common.api.IWeatherInfoApi;
import com.sogeti.weatherapp.common.model.Daily;
import com.sogeti.weatherapp.common.model.ForecastWeatherInfo;
import com.sogeti.weatherapp.common.model.StandardWeatherInfo;
import com.sogeti.weatherapp.common.model.WeatherInfo;

import static com.sogeti.weatherapp.common.utils.DateTimeUtil.*;

public class PremiumWeatherInfoApi implements IWeatherInfoApi {
    @Override
    public StandardWeatherInfo getWeatherInfo(String city, WeatherInfo weatherInfo) {
        StandardWeatherInfo stdWeatherInfo = new StandardWeatherInfo();
        stdWeatherInfo.setCity(city);
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

    @Override
    public ForecastWeatherInfo getForecastInfo(String city, WeatherInfo weatherInfo) {
        ForecastWeatherInfo forecastWeatherInfo = new ForecastWeatherInfo();
        weatherInfo.getDaily().remove(0);
        for (Daily daily: weatherInfo.getDaily()) {
            StandardWeatherInfo stdWeatherInfo = new StandardWeatherInfo();
            stdWeatherInfo.setCity(city);
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
