package com.example.coinmarketcapbot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RestTemplateService {
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;
    private final ObjectMapper objectMapper;

    public RestTemplateService(RestTemplate restTemplate, HttpHeaders httpHeaders, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
        this.objectMapper = objectMapper;
    }

    public String getResponseFromURL(String url, Map<String, String> parameters) {

        try {
            url = refactorUrlWithParametersSerch(url, parameters);
            System.out.println(url);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url,
                    HttpMethod.GET,
                    new HttpEntity<>(httpHeaders),
                    String.class);
            String response = responseEntity.getBody();
            return response;

        } catch (RestClientException e) {
            throw new RestClientException("REST REQUEST ERROR -> " + e);
        }
    }


    private static String refactorUrlWithParametersSerch(String url, Map<String, String> parameters) {
        StringBuilder stringBuilder = new StringBuilder(url);
        if (!parameters.isEmpty()) {
            stringBuilder.append("?");
            parameters.forEach((key, value) -> {
                stringBuilder.append(key.trim()).append("=").append(value.trim()).append("&");
            });
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public <T> Object convertJsonToObject(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception e) {
            throw new RuntimeException("CONVERT JSON TO OBJECT ERROR -> " + e);
        }
    }

}
