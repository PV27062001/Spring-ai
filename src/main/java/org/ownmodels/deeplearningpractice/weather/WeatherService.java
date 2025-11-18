package org.ownmodels.deeplearningpractice.weather;


import lombok.RequiredArgsConstructor;
import org.ownmodels.deeplearningpractice.externalapi.weather.WeatherExternalApiService;
import org.ownmodels.deeplearningpractice.externalapi.weather.CityInfo;
import org.ownmodels.deeplearningpractice.externalapi.weather.weatherinfo.WeatherResponse;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherExternalApiService weatherExternalApiService;

    @Tool(description = "Get the info for a city {cityName}")
    public List<CityInfo> getInfoForCityName(@ToolParam(description = "cityName, e.g. Chennai") String cityName){
        return weatherExternalApiService.getDetailsByCityName(cityName);
    }

    @Tool(description = "Get the weather info for a city {cityName}")
    public WeatherResponse getWeatherInfoForCityName(@ToolParam(description = "cityName, e.g. Chennai") String cityName,
                                                     @ToolParam(description = "language, e.g. english") String language

    ){
        language = "english";
        return weatherExternalApiService.getWeatherByCityName(cityName,language);
    }
}
