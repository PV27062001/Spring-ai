package org.ownmodels.deeplearningpractice.externalapi.weather.weatherinfo;

import lombok.Data;

@Data
public class Condition {
    private String text;
    private String icon;
    private Integer code;
}
