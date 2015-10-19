package no.frodo.moap.persistence;

import no.frodo.moap.domain.Weather;

import java.io.IOException;

public interface WeatherRepository {
    Weather getWeatherForCity(String name) throws IOException;
}
