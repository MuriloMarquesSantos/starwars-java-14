package com.starwars.swapi.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Error(@JsonProperty  String message) { }
