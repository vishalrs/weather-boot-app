package com.sogeti.weatherapp.api.standard;
import com.sogeti.weatherapp.common.api.IWeatherInfoApi;
import com.sogeti.weatherapp.common.model.ForecastWeatherInfo;
import com.sogeti.weatherapp.common.model.StandardWeatherInfo;
import com.sogeti.weatherapp.common.model.WeatherInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.sogeti.weatherapp.common.utils.DateTimeUtil.convertUTCToDateTime;
import static com.sogeti.weatherapp.common.utils.DateTimeUtil.convertUTCToTime;

public class StandardWeatherInfoApi implements IWeatherInfoApi {

    @Override
    public StandardWeatherInfo getWeatherInfo(String city, WeatherInfo weatherInfo) {
        StandardWeatherInfo stdWeatherInfo = new StandardWeatherInfo();
        stdWeatherInfo.setCity(city);
        stdWeatherInfo.setCurrentDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm")));
        stdWeatherInfo.setCurrentDateTime(convertUTCToDateTime(weatherInfo.getCurrent().getDt(), weatherInfo.getTimezone()));
        stdWeatherInfo.setDescription(weatherInfo.getCurrent().getWeather().get(0).getDescription());
        stdWeatherInfo.setCurrentTemp(weatherInfo.getCurrent().getTemp());
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
        //No implementation as standard subscription do not allow this
        return null;
    }


}
