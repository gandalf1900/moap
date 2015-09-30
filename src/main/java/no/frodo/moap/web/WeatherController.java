package no.frodo.moap.web;

import no.frodo.moap.domain.City;
import no.frodo.moap.data.WeatherRepository;
import no.frodo.moap.service.CityRegistrationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class WeatherController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private CityRegistrationService cityRegistration;

    @Inject
    private WeatherRepository cityDao;
    private String name;
    private String weatherInfo;

    @Produces
    @Named
    private City newCity;

    @PostConstruct
    public void initNewCity() {
        newCity = new City();
    }

    public void register() throws Exception {
        try {
            cityRegistration.register(newCity);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
            initNewCity();
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    public void getWeather() throws IOException {
        City city = cityDao.getForCityName(name);
        if (city != null) {
            weatherInfo = "test";
        } else {
            weatherInfo = "null";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    private String getRootErrorMessage(Exception e) {
        // Default to general error message that registration failed.
        String errorMessage = "Registration failed. See server log for more information";
        if (e == null) {
            // This shouldn't happen, but return the default messages
            return errorMessage;
        }

        // Start with the exception and recurse to find the root cause
        Throwable t = e;
        while (t != null) {
            // Get the message from the Throwable class instance
            errorMessage = t.getLocalizedMessage();
            t = t.getCause();
        }
        // This is the root cause message
        return errorMessage;
    }
}
