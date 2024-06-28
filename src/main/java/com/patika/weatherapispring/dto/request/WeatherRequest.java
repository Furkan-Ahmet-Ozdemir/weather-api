package com.patika.weatherapispring.dto.request;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WeatherRequest {
    @NotBlank(message = "City is required")
    private String city;

    private String country;
}