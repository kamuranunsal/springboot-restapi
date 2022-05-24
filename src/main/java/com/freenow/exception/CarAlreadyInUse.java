package com.freenow.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason= "Car already in use")
public class CarAlreadyInUse extends  Exception{
    public CarAlreadyInUse(String message){
        super(message);
    }
}
