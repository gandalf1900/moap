package no.frodo.moap.service;

import no.frodo.moap.data.CityRepository;
import no.frodo.moap.domain.City;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Stateless
public class CityRegistrationService {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private CityRepository cityRepository;


    @Inject
    private Event<City> memberEventSrc;

    public void register(City city) throws Exception {
        cityRepository.addCity(city);
    }

    public void delete(City city) throws Exception {
        cityRepository.removeCity(city);
    }
}
