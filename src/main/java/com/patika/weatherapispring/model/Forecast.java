package com.patika.weatherapispring.model;
import lombok.Data;

import java.util.List;

@Data
public class Forecast {
    private List<ForecastDay> forecastday;
}
