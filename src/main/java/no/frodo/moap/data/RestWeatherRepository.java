package no.frodo.moap.data;


import no.frodo.moap.data.WeatherRepository;
import no.frodo.moap.domain.City;
import no.frodo.moap.domain.Weather;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class RestWeatherRepository implements WeatherRepository {
    @Override
    public Weather getWeatherForCity(String name) throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+name;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode() + " for city "+name );

        return null;
    }
}
