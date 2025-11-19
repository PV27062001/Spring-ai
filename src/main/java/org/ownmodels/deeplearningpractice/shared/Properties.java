package org.ownmodels.deeplearningpractice.shared;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Properties {

    @Value("${Weather.api.key}")
    private String weatherKey;

    @Value("${Weather.api.city.info.url}")
    private String cityInfoUrl;

    @Value("${Weather.api.city.weather.url}")
    private String weatherInfoUrl;

}