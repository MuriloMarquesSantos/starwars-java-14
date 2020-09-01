package com.starwars.swapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.swapi.domain.Person;
import com.starwars.swapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PeopleService {

    public Person getPerson(String id) throws IOException, InterruptedException {
        var httpClient = HttpClient.newHttpClient();
        var request = buildHttpRequest(id);
        var response = sendHttpRequest(httpClient, request);

        return convertResponseIntoEntity(response);
    }

    private HttpRequest buildHttpRequest(String id) {
        return HttpRequest
                .newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create("https://swapi.dev/api/people/"+id+"/"))
                .build();
    }

    private HttpResponse<String> sendHttpRequest(HttpClient client, HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new ResourceNotFoundException();
        }

        return response;
    }

    private Person convertResponseIntoEntity(HttpResponse<String> response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return objectMapper.readValue(response.body(), Person.class);
    }
}
