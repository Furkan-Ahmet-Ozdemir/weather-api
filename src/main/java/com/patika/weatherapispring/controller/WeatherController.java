package com.patika.weatherapispring.controller;
import com.patika.weatherapispring.dto.response.WeatherResponse;
import com.patika.weatherapispring.service.WeatherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/daily")
    public ResponseEntity<WeatherResponse> getDailyWeather(@RequestParam @Valid String city) {
        WeatherResponse response = weatherService.getDailyWeather(city);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/weekly")
    public ResponseEntity<WeatherResponse> getWeeklyWeather(@RequestParam @Valid String city) {
        WeatherResponse response = weatherService.getWeeklyWeather(city);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/monthly")
    public ResponseEntity<WeatherResponse> getMonthlyWeather(@RequestParam @Valid String city) {
        WeatherResponse response = weatherService.getMonthlyWeather(city);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}