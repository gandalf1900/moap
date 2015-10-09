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

@ManagedBean
@RequestScoped
public class WeatherPrimeView {

    @Inject
    private FacesContext facesContext;

    @Inject
    CityRegistrationService cityRegistrationService;

    @Inject
    private WeatherService weatherService;

    @Produces
    @Named
    private City newPrimeCity;

    @Named
    private String weatherInfo;

    @Named
    private String weatherForCity;

    @PostConstruct
    public void initWeatherApp() {
        newPrimeCity = new City();
    }

    public void register() throws Exception {
        try {
            cityRegistrationService.register(newPrimeCity);
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful for city "+newPrimeCity.getName());
            facesContext.addMessage(null, m);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    public void weather() throws IOException {
        Weather weather = weatherService.getWeatherForCity(weatherForCity);
        FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Get weather successful");
        facesContext.addMessage(null, m);
        if (weather != null) {
            weatherInfo = weather.getWeatherData();
        } else {
            weatherInfo = "null";
        }
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

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public String getWeatherForCity() {
        return weatherForCity;
    }

    public void setWeatherForCity(String weatherForCity) {
        this.weatherForCity = weatherForCity;
    }
}
