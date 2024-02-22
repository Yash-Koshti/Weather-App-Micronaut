package com.weather.com;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WeatherControllerShould {
  @Mock
  WeatherService weatherService;
  @InjectMocks
  WeatherController weatherController;

  @Test
  @DisplayName("calls weather service get by zip code")
  void calls_weather_service_get_by_zip_code() {
      weatherController.getByZip("01581");
      verify(weatherService).getByZip("01581");
  }
}
