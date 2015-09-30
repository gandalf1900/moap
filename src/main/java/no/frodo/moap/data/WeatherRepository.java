package no.frodo.moap.data;

import no.frodo.moap.domain.City;

import java.io.IOException;

public interface WeatherRepository {
    City getForCityName(String name) throws IOException;
}
