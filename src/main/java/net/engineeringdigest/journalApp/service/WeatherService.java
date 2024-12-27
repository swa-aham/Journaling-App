package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String API_KEY = "***";

    private final String URL = "http://api.weatherstack.com/current?access_key=KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;


    public WeatherResponse getTemp(String city) {
        String endPoint = URL.replace("CITY", city).replace("KEY", API_KEY);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(endPoint, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = response.getBody();
        return body;
    }
}
