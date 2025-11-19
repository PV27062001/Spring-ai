package org.ownmodels.deeplearningpractice.externalapi.weather;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class CityInfo {
    private String id;
    private String name;
    private String region;
    private String country;
    private Double lat;
    private Double lon;
    private String url;
}
