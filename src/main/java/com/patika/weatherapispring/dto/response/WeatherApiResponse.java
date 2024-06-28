package com.patika.weatherapispring.dto.response;
import com.patika.weatherapispring.model.Current;
import com.patika.weatherapispring.model.Forecast;
import com.patika.weatherapispring.model.Location;
import lombok.Data;

@Data
public class WeatherApiResponse {
    private Location location;
    private Current current;
    private Forecast forecast;
}