package com.freenow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "There is no car used by driver")
public class DriverHasNoSelectedCar extends Exception{
    public DriverHasNoSelectedCar(String message){
        super(message);
    }
}
