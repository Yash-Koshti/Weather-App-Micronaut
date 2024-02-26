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

  @Test
  @DisplayName("retrieve weather by country")
  void retrieve_weather_by_country() {
    Weather weather = client.toBlocking().exchange("/weather/country/France", Weather.class).body();
    assertThat(weather.location().name()).isEqualTo("Paris");
    assertThat(weather.location().region()).isEqualTo("Ile-de-France");
  }

  @Test
  @DisplayName("retrieve weather by IP address")
  void retrieve_weather_by_ip_address() {
    Weather weather = client.toBlocking().exchange("/weather/ip/100.0.0.1", Weather.class).body();
    assertThat(weather.location().name()).isEqualTo("Boston");
    assertThat(weather.location().region()).isEqualTo("Massachusetts");
  }
}
