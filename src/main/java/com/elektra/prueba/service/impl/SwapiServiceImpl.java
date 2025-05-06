package com.elektra.prueba.service.impl;

import com.elektra.prueba.service.SwapiService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Random;

@Service
public class SwapiServiceImpl implements SwapiService {

    private final RestTemplate restTemplate;
    private final int MAX_PLANETS = 60;

    public SwapiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String obtenerPlanetaAleatorio() {
        int id = new Random().nextInt(MAX_PLANETS) + 1;
        String url = "https://www.swapi.tech/api/planets/" + id;

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
            if (response != null && response.containsKey("result")) {
                Map<String, Object> result = (Map<String, Object>) response.get("result");
                Map<String, Object> properties = (Map<String, Object>) result.get("properties");
                return (String) properties.get("name");
            }
        } catch (Exception e) {
            return "Desconocido";
        }

        return "Desconocido";
    }
}
