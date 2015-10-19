package no.frodo.moap.domain;

public class Weather {
    //private String city;
    private String weatherData;

    public Weather(String json) {
        this.weatherData = json;
    }

    /*
    public String  getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
      */

    public String getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(String weatherData) {
        this.weatherData = weatherData;
    }
}
