package org.ownmodels.deeplearningpractice.weather;


import lombok.RequiredArgsConstructor;
import org.ownmodels.deeplearningpractice.externalapi.weather.CityInfo;
import org.ownmodels.deeplearningpractice.externalapi.weather.weatherinfo.WeatherResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/cityname")
    public ResponseEntity<List<CityInfo>> getCityInfo(@RequestParam String cityName){
        return ResponseEntity.ok(weatherService.getInfoForCityName(cityName));
    }

    @GetMapping("/weather-info/byCity")
    public WeatherResponse getCWeatherInfoByCity(@RequestParam String cityName, @RequestParam String language){
        return (weatherService.getWeatherInfoForCityName(cityName,language));
    }
}
