package com.patika.weatherapispring.dto.response;
import lombok.Data;

@Data
public class MonthlyWeather {
    private String month;
    private String condition;
    private double temperature;

}