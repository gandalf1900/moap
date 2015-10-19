package no.frodo.moap.data;

import no.frodo.moap.domain.City;
import no.frodo.moap.domain.Weather;

import java.io.IOException;

public interface WeatherRepository {
    Weather getWeatherForCity(String name) throws IOException;
}
