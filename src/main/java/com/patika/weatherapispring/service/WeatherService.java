package com.patika.weatherapispring.service;
import com.patika.weatherapispring.dto.response.DailyWeather;
import com.patika.weatherapispring.dto.response.WeatherApiResponse;
import com.patika.weatherapispring.dto.response.WeatherResponse;
import com.patika.weatherapispring.model.ForecastDay;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
    private final String apiUrl = "http://api.weatherapi.com/v1";

    private RestTemplate restTemplate = new RestTemplate();

    public WeatherResponse getDailyWeather(String q) {
        return getWeatherForecast(q, 1);
    }

    public WeatherResponse getWeeklyWeather(String q) {
        return getWeatherForecast(q, 7);
    }

    public WeatherResponse getMonthlyWeather(String q) {
        return getWeatherForecast(q, 30);
    }

    private WeatherResponse getWeatherForecast(String q, int days) {
        String url = String.format("%s/forecast.json?key=%s&q=%s&days=%d", apiUrl, apiKey, q, days);
        ResponseEntity<WeatherApiResponse> response = restTemplate.getForEntity(url, WeatherApiResponse.class);
        return mapToWeatherResponse(response.getBody());
    }

    private WeatherResponse mapToWeatherResponse(WeatherApiResponse apiResponse) {
        WeatherResponse response = new WeatherResponse();
        response.setLocation(apiResponse.getLocation().getName());
        response.setCountry(apiResponse.getLocation().getCountry());

        List<DailyWeather> dailyWeathers = new ArrayList<>();
        for (ForecastDay forecastDay : apiResponse.getForecast().getForecastday()) {
            DailyWeather dailyWeather = new DailyWeather();
            dailyWeather.setDate(forecastDay.getDate());
            dailyWeather.setCondition(forecastDay.getDay().getCondition().getText());
            dailyWeather.setTemperature(forecastDay.getDay().getAvgtemp_c());
            dailyWeathers.add(dailyWeather);
        }
        response.setDailyForecast(dailyWeathers);


        return response;
    }
}