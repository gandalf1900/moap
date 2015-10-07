package no.frodo.moap.web;

import no.frodo.moap.domain.City;
import no.frodo.moap.domain.Weather;
import no.frodo.moap.service.CityRegistrationService;
import no.frodo.moap.service.WeatherService;

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
    private CityRegistrationService cityRegistrationService;

    @Inject
    private WeatherService weatherService;

    @Named
    private String weatherInfo;

    @Produces
    @Named
    private City newCity;

    @Produces
    @Named
    private String weatherForCity;

    @PostConstruct
    public void initWeatherApp() {
        newCity = new City();
    }

    public void register() throws Exception {
        try {
            cityRegistrationService.register(newCity);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            String errorMessage = getRootErrorMessage(e);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    public void weather() throws IOException {
        Weather weather = weatherService.getWeatherForCity(weatherForCity);
        if (weather != null) {
            weatherInfo = weather.getWeatherData();
        } else {
            weatherInfo = "null";
        }
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


    public String getWeatherForCity() {
        return weatherForCity;
    }

    public void setWeatherForCity(String weatherForCity) {
        this.weatherForCity = weatherForCity;
    }


    public String getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }
}
