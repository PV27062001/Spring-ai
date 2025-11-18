package org.ownmodels.deeplearningpractice.externalapi.weather.weatherinfo;

import lombok.Data;

@Data
public class Current {
    private Long last_updated_epoch;
    private String last_updated;
    private Double temp_c;
    private Double temp_f;
    private Integer is_day;
    private Condition condition;
    private Double wind_mph;
    private Double wind_kph;
    private Integer wind_degree;
    private String wind_dir;
    private Double pressure_mb;
    private Double pressure_in;
    private Double precip_mm;
    private Double precip_in;
    private Integer humidity;
    private Integer cloud;
    private Double feelslike_c;
    private Double feelslike_f;
    private Double windchill_c;
    private Double windchill_f;
    private Double heatindex_c;
    private Double heatindex_f;
    private Double dewpoint_c;
    private Double dewpoint_f;
    private Double vis_km;
    private Double vis_miles;
    private Double uv;
    private Double gust_mph;
    private Double gust_kph;
    private Double short_rad;
    private Double diff_rad;
    private Double dni;
    private Double gti;
}
