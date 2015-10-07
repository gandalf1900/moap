package no.frodo.moap.data;

import no.frodo.moap.domain.City;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class JpaCityRepository implements CityRepository {

    @Inject
    private Logger log;

    @Inject
    private EntityManager em;

    @Inject
    private Event<City> memberEventSrc;

    @Override
    public String findByName(String name) {
        return null;
    }

    @Override
    public String findByNameLike(String name) {
        return null;
    }

    public List<City> findAllCitiesOrderedByName() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<City> criteria = cb.createQuery(City.class);
        Root<City> city = criteria.from(City.class);
        criteria.select(city).orderBy(cb.asc(city.get("name")));
        return em.createQuery(criteria).getResultList();
    }

    @Override
    public void addCity(City city) {
        log.info("Registering new city " + city.getName());
        em.persist(city);
        memberEventSrc.fire(city);
    }

    @Override
    public void removeCity(City city) {

    }

    @Override
    public void updateCity(City account) {

    }

    public void register(City city) throws Exception {
        log.info("Registering " + city.getName());
        em.persist(city);
        memberEventSrc.fire(city);
    }
}
