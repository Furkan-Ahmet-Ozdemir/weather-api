package com.patika.weatherapispring.dto.response;
import lombok.Data;

@Data
public class DailyWeather {
    private String date;
    private String condition;
    private double temperature;
}
