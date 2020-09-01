package com.starwars.swapi.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        this(null);
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
