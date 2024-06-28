package com.patika.weatherapispring.model;
import lombok.Data;

@Data
public class Day {
    private double avgtemp_c;
    private Condition condition;
}
