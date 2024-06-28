package com.patika.weatherapispring.dto.response;
import lombok.Data;

import java.util.List;

@Data
public class WeatherResponse {
    private String location;
    private String country;
    private List<DailyWeather> dailyForecast;
    private List<WeeklyWeather> weeklyForecast;
    private List<MonthlyWeather> monthlyForecast;

}