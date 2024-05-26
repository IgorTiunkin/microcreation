package com.phantom.orderservice.controllers;

import com.phantom.orderservice.dtos.ItemDTO;
import com.phantom.orderservice.dtos.OrderDTO;
import com.phantom.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity <List<OrderDTO>> findAllOrders() {
        List<OrderDTO> allOrders = orderService.findAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }

    @GetMapping("/all-items")
    public ResponseEntity<List<ItemDTO>> getALlItems() throws ExecutionException, InterruptedException {
        List <ItemDTO> all = orderService.findAllItems().get();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
