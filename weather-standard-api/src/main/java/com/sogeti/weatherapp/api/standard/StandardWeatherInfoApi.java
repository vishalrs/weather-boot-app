package com.sogeti.weatherapp.api.standard;
import com.sogeti.weatherapp.common.api.IWeatherInfoApi;
import com.sogeti.weatherapp.common.model.ForecastWeatherInfo;
import com.sogeti.weatherapp.common.model.Location;
import com.sogeti.weatherapp.common.model.StandardWeatherInfo;
import com.sogeti.weatherapp.common.model.WeatherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static com.sogeti.weatherapp.common.utils.DateTimeUtil.convertUTCToDateTime;
import static com.sogeti.weatherapp.common.utils.DateTimeUtil.convertUTCToTime;

@Service
public class StandardWeatherInfoApi implements IWeatherInfoApi {

    RestTemplate restTemplate;

    public StandardWeatherInfoApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public StandardWeatherInfo getWeatherInfo(Location location) {
        Map<String, String> params = Map.of("lat", location.getLat(), "lng", location.getLng());
        WeatherInfo weatherInfo = restTemplate.getForObject("", WeatherInfo.class, params);

        StandardWeatherInfo stdWeatherInfo = new StandardWeatherInfo();
        stdWeatherInfo.setCity(location.getCity());
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
    public ForecastWeatherInfo getForecastInfo(Location location) {
        //No implementation as standard subscription do not allow this
        return null;
    }


}
