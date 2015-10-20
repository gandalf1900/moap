package no.frodo.moap.persistence;

import no.frodo.moap.domain.City;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
    public City findById(Long id) {
        TypedQuery<City> query = em.createQuery("select c from City c where c.id = :id", City.class);
        query.setParameter("id", id);
        City result = query.getSingleResult();
        return result;
    }

    @Override
    public List<City> findByNameLike(String prefix) {
        log.info("findByNameLike");

        List<City> resultList = null;

        try {
            final TypedQuery<City> query = em.createQuery("select c from City c where (lower(c.name) like :prefix)", City.class);
            final TypedQuery<City> typedQuery = query.setParameter("prefix", prefix.toLowerCase() + "%");
            resultList = typedQuery.getResultList();
            return resultList;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resultList;

    }

    public List<City> findAllCitiesOrderedByName() {
        log.info("findAllCitiesOrderedByName");

        List<City> resultList = null;

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<City> criteria = cb.createQuery(City.class);
            Root<City> city = criteria.from(City.class);
            criteria.select(city).orderBy(cb.asc(city.get("name")));
            final TypedQuery<City> query = em.createQuery(criteria);
            resultList = query.getResultList();
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resultList;
    }

    @Override
    public void addCity(City city) {
        log.info("Registering new city " + city.getName());

        try {
            em.persist(city);
            memberEventSrc.fire(city);
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeCity(City city) {
        log.info("Removing city " + city.getName());

        try {
            boolean b = em.contains(city);

            Long id = city.getId();
            City cc =  em.find(City.class, id);
            if (cc != null) {
                em.remove(cc);
            }
            memberEventSrc.fire(city);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void updateCity(City account) {
        throw new UnsupportedOperationException();

    }
}
