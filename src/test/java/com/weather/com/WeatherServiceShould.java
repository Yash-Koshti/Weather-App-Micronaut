package com.weather.com;


import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WeatherServiceShould {
    @Mock
    WeatherApi weatherApi;
    WeatherService weatherService;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherService(weatherApi);
    }
    @Test
    @DisplayName("call weather api to retrieve realtime weather by zip code")
    void retrieve_realtime_weather_by_zip_code() {
        weatherService.getByZip("01581");
        verify(weatherApi).getWeather("01581");
    }

    @Test
    @DisplayName("retrieve realtime weather by city")
    void retrieve_realtime_weather_by_city() {
        weatherService.getByCity("Westborough");
        verify(weatherApi).getWeather("Westborough");
    }

    @Test
    @DisplayName("retrieve realtime weather by country")
    void retrieve_realtime_weather_by_country() {
        weatherService.getByCountry("France");
        verify(weatherApi).getWeather("France");
    }
}
