package no.frodo.moap.data;

import no.frodo.moap.domain.City;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
public class CityListProducer {

    @Inject
    private CityRepository cityRepository;

    private List<City> cityList;

    @Produces
    @Named
    public List<City> getCities() {
        return cityList;
    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final City member) {
        retrieveAllMembersOrderedByName();
    }

    @PostConstruct
    public void retrieveAllMembersOrderedByName() {
        cityList = cityRepository.findAllOrderedByName();
    }
}
