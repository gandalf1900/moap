package no.frodo.moap.persistence;

import no.frodo.moap.domain.City;

import java.util.List;

public interface CityRepository {

    public String findByName(String name);

    public City findById(Long id);

    public List<City> findByNameLike(String name);

    public List<City> findAllCitiesOrderedByName();

    void addCity(City city);

    void removeCity(City city);

    void updateCity(City account);
}
