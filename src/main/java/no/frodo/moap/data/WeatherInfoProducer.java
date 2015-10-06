package no.frodo.moap.data;

import no.frodo.moap.domain.City;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.List;

@RequestScoped
public class WeatherInfoProducer {

    private String weatherInfo;

    @Produces
    @Named
    public String getWeatherInfo() {
        return weatherInfo;
    }
}
