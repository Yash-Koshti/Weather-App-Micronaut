package com.weather.com;

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@MicronautTest
class WeatherControllerTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  @DisplayName("retrieves weather by zip code")
  void retrieves_weather_by_zip_code() {
    Weather weather = client.toBlocking().exchange("/weather/zip/01581", Weather.class).body();
    assertThat(weather.location().name()).isEqualTo("Westborough");
    assertThat(weather.location().region()).isEqualTo("Massachusetts");
  }

  @Test
  @DisplayName("retrieve weather by city")
  void retrieve_weather_by_city() {
    Weather weather = client.toBlocking().exchange("/weather/city/Westborough", Weather.class).body();
    assertThat(weather.location().name()).isEqualTo("Westborough");
    assertThat(weather.location().region()).isEqualTo("Massachusetts");
  }
}
