package no.frodo.moap.web;

import no.frodo.moap.domain.City;
import no.frodo.moap.domain.Weather;
import no.frodo.moap.service.CityRegistrationService;
import no.frodo.moap.service.WeatherService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class WeatherView {

    @Inject
    private FacesContext facesContext;

    @Inject
    private WeatherService weatherService;

    @Inject
    CityRegistrationService cityRegistrationService;

    @Named
    private String weatherInfo;

    @Produces
    @Named
    private String weatherForCity;

    /**
     * Hent ut vær
     * @return
     */
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

    /**
     * Hent ut city by autocomplete
     * @param query
     * @return
     */
    public List<String> findCityByPrefix(String query) {
        List<City> results = null;
        try {
            results = cityRegistrationService.findByNameLike(query);
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "findCityByPrefix unsuccessful");
            facesContext.addMessage(null, m);
        }

        List<String> cityListAsString = new ArrayList();
        for (City c : results) {
            cityListAsString.add(c.getName());
        }

        return cityListAsString;
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
