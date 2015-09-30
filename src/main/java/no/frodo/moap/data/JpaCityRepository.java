package no.frodo.moap.data;

import no.frodo.moap.domain.City;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@ApplicationScoped
public class JpaCityRepository implements CityRepository {

    @Inject
    private EntityManager em;

    @Override
    public String findByName(String name) {
        return null;
    }

    @Override
    public String findByNameLike(String name) {
        return null;
    }

    public List<City> findAllOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<City> criteria = cb.createQuery(City.class);
        Root<City> city = criteria.from(City.class);
        criteria.select(city).orderBy(cb.asc(city.get("name")));
        return em.createQuery(criteria).getResultList();
    }

    @Override
    public void addCity(City city) {

    }

    @Override
    public void removeCity(City city) {

    }

    @Override
    public void updateCity(City account) {

    }
}
