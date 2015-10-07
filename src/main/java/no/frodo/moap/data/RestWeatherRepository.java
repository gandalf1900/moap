package no.frodo.moap.data;


import no.frodo.moap.data.WeatherRepository;
import no.frodo.moap.domain.City;
import no.frodo.moap.domain.Weather;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


import java.io.IOException;

public class RestWeatherRepository implements WeatherRepository {
    @Override
    public Weather getWeatherForCity(String name) throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q="+name;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        HttpEntity responseEntity = response.getEntity();

        String json = EntityUtils.toString(responseEntity);

        System.out.println(json);

        JSONObject obj=new JSONObject(json);

        System.out.println(obj.toString(2));

        System.out.println("Response Code : " + response.getStatusLine().getStatusCode() + " for city "+name );

        return new Weather(json);
    }
}
