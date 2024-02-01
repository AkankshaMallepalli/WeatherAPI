package com.example.Weather1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private static final String BASE_URL = "https://api.weatherapi.com/v1/current.json";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTemperature(String zipcode) {
        String apiUrl = BASE_URL + "?key=" + apiKey + "&q=" + zipcode;
        return restTemplate.getForObject(apiUrl, String.class);
    }
}

