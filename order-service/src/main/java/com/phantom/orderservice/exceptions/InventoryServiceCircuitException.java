package com.phantom.orderservice.exceptions;

public class InventoryServiceCircuitException extends RuntimeException{
    public InventoryServiceCircuitException(String message) {
        super(message);
    }
}
