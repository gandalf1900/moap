package no.frodo.moap.web;

import no.frodo.moap.domain.City;
import no.frodo.moap.domain.Weather;
import no.frodo.moap.service.CityRegistrationService;
import no.frodo.moap.service.WeatherService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class CityRegistrationView {

    @Inject
    private FacesContext facesContext;

    @Inject
    CityRegistrationService cityRegistrationService;

    @Produces
    @Named
    private City newPrimeCity;

    @PostConstruct
    public void initWeatherApp() {
        newPrimeCity = new City();
    }

    /**
     * Registrer ny by
     * @throws Exception
     */
    public void registerNewCity() throws Exception {
        try {
            cityRegistrationService.register(newPrimeCity);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful for city "+newPrimeCity.getName());
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    /**
     * Hent ut city by autocomplete
     * @param query
     * @return
     */
    public List<City> findCityByPrefix(String query) {
        List<City> results = null;
        try {
            results = cityRegistrationService.findByNameLike(query);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "findCityByPrefix unsuccessful");
            facesContext.addMessage(null, m);
        }

        return results;
    }

    public String delete(City city) {

        try {
            String name = city.getName();
            cityRegistrationService.delete(city);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Delete successful for city "+name);
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Delete unsuccessful");
            facesContext.addMessage(null, m);
        }

        System.out.println("delete city "+city.getName());
        return null;
    }

    public City getNewPrimeCity() {
        return newPrimeCity;
    }

    public void setNewPrimeCity(City newPrimeCity) {
        this.newPrimeCity = newPrimeCity;
    }


}
