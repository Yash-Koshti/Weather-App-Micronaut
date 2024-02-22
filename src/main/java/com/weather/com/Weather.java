package com.weather.com;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Introspected
@Serdeable.Serializable
@Serdeable.Deserializable
public record Weather(Location location) {
}
