package com.starwars.swapi.controller;

import com.starwars.swapi.domain.Person;
import com.starwars.swapi.service.PeopleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public Person getPerson() throws IOException, InterruptedException {
        return peopleService.getPerson();
    }
}
