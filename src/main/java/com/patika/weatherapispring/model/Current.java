package com.patika.weatherapispring.model;
import lombok.Data;

@Data
public class Current {
    private long lastUpdatedEpoch;
    private String lastUpdated;
    private double tempC;
    private double tempF;
    private int isDay;
    private Condition condition;
    private double windMph;
    private double windKph;
    private int windDegree;
    private String windDir;
    private double pressureMb;
    private double pressureIn;
    private double precipMm;
    private double precipIn;
    private int humidity;
    private int cloud;
    private double feelslikeC;
    private double feelslikeF;
    private double visKm;
    private double visMiles;
    private double uv;
    private double gustMph;
    private double gustKph;
}