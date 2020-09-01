package com.starwars.swapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Person(@JsonProperty("name") String name,
                     @JsonProperty("height") String height,
                     @JsonProperty("hair_color") String hair_color,
                     @JsonProperty("skin_color") String skin_color,
                     @JsonProperty("birth_year") String birth_year,
                     @JsonProperty("gender") String gender) { }
