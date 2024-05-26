package com.phantom.orderservice.handlers;

import com.phantom.orderservice.exceptions.InventoryServiceCircuitException;
import com.phantom.orderservice.exceptions.InventoryServiceException;
import com.phantom.orderservice.exceptions.InventoryServiceTimeoutException;
import com.phantom.orderservice.exceptions.InventoryServiceTooManyRequestsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(InventoryServiceCircuitException.class)
    public ResponseEntity <String> handleInventoryServiceCircuitException (InventoryServiceCircuitException e) {
        log.info("InventoryServiceCircuitException handled");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(InventoryServiceTimeoutException.class)
    public ResponseEntity <String> handleInventoryServiceTimeoutException (InventoryServiceTimeoutException e) {
        log.info("InventoryServiceTimeoutException handled");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.REQUEST_TIMEOUT);
    }

    @ExceptionHandler(InventoryServiceTooManyRequestsException.class)
    public ResponseEntity <String> handleInventoryServiceTooManyRequestsException (InventoryServiceTooManyRequestsException e) {
        log.info("InventoryServiceTooManyRequestsException handled");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.TOO_MANY_REQUESTS);
    }

    @ExceptionHandler(InventoryServiceException.class)
    public ResponseEntity <String> handleInventoryServiceException (InventoryServiceException e) {
        log.info("InventoryServiceException handled");
        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
