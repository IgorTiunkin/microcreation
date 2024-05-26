package com.phantom.orderservice.services;

import com.phantom.orderservice.dtos.ItemDTO;
import com.phantom.orderservice.dtos.OrderDTO;
import com.phantom.orderservice.exceptions.InventoryServiceCircuitException;
import com.phantom.orderservice.exceptions.InventoryServiceException;
import com.phantom.orderservice.exceptions.InventoryServiceTimeoutException;
import com.phantom.orderservice.exceptions.InventoryServiceTooManyRequestsException;
import com.phantom.orderservice.mappers.OrderMapper;
import com.phantom.orderservice.repositories.OrderRepository;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryService inventoryService;

    public List <OrderDTO> findAllOrders(){
        return orderMapper.toDTOs(orderRepository.findAll());
    }

    @Retry(name = "inventory", fallbackMethod = "inventoryFail")
    @CircuitBreaker(name = "inventory", fallbackMethod = "inventoryCircuit")
    @TimeLimiter(name = "inventory", fallbackMethod = "inventoryTimeout")
    @RateLimiter(name = "inventory", fallbackMethod = "inventoryTooManyRequests")
    public CompletableFuture <List<ItemDTO>> findAllItems() {
        log.info("Order Service: Start getting all items");
        return CompletableFuture.supplyAsync(() -> inventoryService.getAllItems().getBody());
    }

    public CompletableFuture <List<ItemDTO>> inventoryCircuit (CallNotPermittedException exception) {
        log.error("Fallback method inventoryCircuit activated, {}", exception.getMessage());
        throw new InventoryServiceCircuitException("Circuit breaker blocks access");
    }

    public CompletableFuture <List<ItemDTO>> inventoryTimeout (TimeoutException exception) {
        log.error("Fallback method inventoryTimeout activated, {}", exception.getMessage());
        throw new InventoryServiceTimeoutException("Service Timeout");
    }

    public CompletableFuture <List<ItemDTO>> inventoryTooManyRequests (RequestNotPermitted exception) {
        log.error("Fallback method inventoryTooManyRequests activated, {}", exception.getMessage());
        throw new InventoryServiceTooManyRequestsException("Too many requests");
    }

    public CompletableFuture <List<ItemDTO>> inventoryFail (Exception exception) {
        log.error("Retry Fallback method activated, {}", exception.getMessage());
        throw new InventoryServiceException(exception.getMessage());
    }

}
