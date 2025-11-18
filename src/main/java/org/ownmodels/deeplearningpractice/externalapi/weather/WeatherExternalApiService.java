package org.ownmodels.deeplearningpractice.externalapi.weather;


import lombok.RequiredArgsConstructor;
import org.ownmodels.deeplearningpractice.externalapi.weather.weatherinfo.WeatherResponse;
import org.ownmodels.deeplearningpractice.shared.Properties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherExternalApiService {

    private final RestTemplate restTemplate;

    private final Properties properties;

    public List<CityInfo> getDetailsByCityName(String cityName){

        if(cityName.isBlank()){
            throw new RuntimeException("City Name is blank");
        }

        String url = properties.getCityInfoUrl()+"?q="+cityName.trim()+"&key="+properties.getWeatherKey();

        ResponseEntity<List<CityInfo>> weatherModels = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<CityInfo>>() {});
//        WeatherModel[] weatherModels = restTemplate.getForObject(url,WeatherModel[].class);

        return weatherModels.getBody();
    }

    public WeatherResponse getWeatherByCityName(String cityName,String language){

        if(cityName.isBlank()){
            throw new RuntimeException("City Name is blank");
        }

        String url = properties.getWeatherInfoUrl()+"?q="+cityName+"&lang="+language+"&key="+properties.getWeatherKey();
        ResponseEntity<WeatherResponse> weatherModels = restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,WeatherResponse.class);
//        WeatherModel[] weatherModels = restTemplate.getForObject(url,WeatherModel[].class);

        return weatherModels.getBody();
    }
}