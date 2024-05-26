package com.phantom.orderservice.services;

import com.phantom.orderservice.dtos.ItemDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient("INVENTORY-SERVICE")
public interface InventoryService {

    @GetMapping("/all")
    ResponseEntity<List<ItemDTO>> getAllItems();
}
