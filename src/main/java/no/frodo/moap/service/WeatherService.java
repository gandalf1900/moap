package no.frodo.moap.service;

import no.frodo.moap.data.WeatherRepository;
import no.frodo.moap.domain.Weather;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.logging.Logger;

@Stateless
public class WeatherService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private WeatherRepository weatherRepository;


    public Weather getWeatherForCity(String name) throws IOException {
        return weatherRepository.getWeatherForCity(name);
    }
}