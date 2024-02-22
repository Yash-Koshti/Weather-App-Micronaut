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
    @DisplayName("call the http client to retrieve realtime weather data")
    void call_the_http_client_to_retrieve_realtime_weather_data() {
        weatherService.getByZip("01581");
        verify(weatherApi).getWeather("01581");
    }
}
