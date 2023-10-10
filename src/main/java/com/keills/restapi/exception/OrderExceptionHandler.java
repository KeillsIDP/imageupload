package com.keills.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderExceptionHandler {
    @ExceptionHandler(value={OrderNotFoundException.class})
    public ResponseEntity handleOrderNotFoundException(OrderNotFoundException orderNotFoundException){
        OrderException orderException = new OrderException(
                orderNotFoundException.getMessage(),
                orderNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(orderException,orderException.getHttpStatus());
    }
}
