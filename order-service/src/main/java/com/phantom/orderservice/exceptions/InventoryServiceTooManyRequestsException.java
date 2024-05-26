package com.phantom.orderservice.exceptions;

public class InventoryServiceTooManyRequestsException extends RuntimeException{
    public InventoryServiceTooManyRequestsException(String message) {
        super(message);
    }
}
