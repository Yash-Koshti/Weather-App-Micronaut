package com.weather.com;

import jakarta.inject.Singleton;

@Singleton
public class WeatherService {
  private final WeatherApi weatherApi;

  public WeatherService(WeatherApi weatherApi) {
    this.weatherApi = weatherApi;
  }

  public Weather getByZip(String zip) {
    return weatherApi.getWeather(zip);
  }

  public Weather getByCity(String city) {
    return weatherApi.getWeather(city);
  }

  public Weather getByCountry(String country) {
    return weatherApi.getWeather(country);
  }
}
