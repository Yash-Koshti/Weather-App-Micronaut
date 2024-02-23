package com.weather.com;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/weather")
public class WeatherController {
 private final WeatherService weatherService;
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

//    @ExecuteOn(TaskExecutors.BLOCKING)
    @Get(uri="/zip/{zip}")
    public Weather getByZip(String zip) {
        return weatherService.getByZip(zip);
    }


    @Get(uri="/city/{city}")
    public Weather getByCity(String city) {
        return weatherService.getByCity(city);
    }
}
