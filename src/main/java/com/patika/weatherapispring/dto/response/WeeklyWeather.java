package com.patika.weatherapispring.dto.response;
import lombok.Data;

@Data
public class WeeklyWeather {
    private String week;
    private String condition;
    private double temperature;
}