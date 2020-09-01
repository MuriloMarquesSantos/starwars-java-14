package com.starwars.swapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Person(@JsonProperty("name") String name, @JsonProperty("height") String height) { }
