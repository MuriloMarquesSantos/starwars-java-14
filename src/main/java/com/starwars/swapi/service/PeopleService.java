package com.starwars.swapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.swapi.domain.Person;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PeopleService {

    public Person getPerson() throws IOException, InterruptedException {
        var httpClient = HttpClient.newHttpClient();
        var request = buildHttpRequest();
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return convertResponseIntoEntity(response);
    }

    private HttpRequest buildHttpRequest() {
        return HttpRequest
                .newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create("https://swapi.dev/api/people/1/"))
                .build();
    }

    private Person convertResponseIntoEntity(HttpResponse<String> response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return objectMapper.readValue(response.body(), Person.class);
    }
}
