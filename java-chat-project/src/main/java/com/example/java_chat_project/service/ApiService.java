package com.example.java_chat_project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {
    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getDataFromApi() {
        String url = "http://localhost:8081/"; 
        return restTemplate.getForObject(url, String.class);
    }
}
