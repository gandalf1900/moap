package no.frodo.moap.data;

import no.frodo.moap.domain.City;

import java.util.List;

public interface CityRepository {

    public String findByName(String name);

    public List<City> findByNameLike(String name);

    public List<City> findAllCitiesOrderedByName();

    void addCity(City city);

    void removeCity(City city);

    void updateCity(City account); // Think it as replace for set
}
