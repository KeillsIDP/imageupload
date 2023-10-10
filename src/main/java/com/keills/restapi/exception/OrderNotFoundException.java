package com.keills.restapi.exception;

import org.springframework.http.HttpStatus;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String message){
        super(message);
    }
    public OrderNotFoundException(String message,Throwable cause){
        super(message,cause);
    }
}
