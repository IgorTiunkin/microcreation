package com.phantom.orderservice.exceptions;

public class InventoryServiceTimeoutException extends RuntimeException{
    public InventoryServiceTimeoutException(String message) {
        super(message);
    }
}
