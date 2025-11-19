package org.ownmodels.deeplearningpractice.externalapi.weather.weatherinfo;


import lombok.Data;

@Data
public class WeatherResponse {

    private Location location;
    private Current current;
}
