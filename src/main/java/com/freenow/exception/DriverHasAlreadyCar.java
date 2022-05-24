package com.freenow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Driver already has a car")
public class DriverHasAlreadyCar extends RuntimeException{
    public DriverHasAlreadyCar(String message){
        super(message);
    }
}
