package com.starwars.swapi.controller;

import com.starwars.swapi.domain.Person;
import com.starwars.swapi.service.PeopleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person getPerson(@PathVariable String id) throws IOException, InterruptedException {
        return peopleService.getPerson(id);
    }
}
