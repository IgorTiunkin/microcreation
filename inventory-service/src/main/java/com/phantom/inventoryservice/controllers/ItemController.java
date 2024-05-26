package com.phantom.inventoryservice.controllers;

import com.phantom.inventoryservice.dtos.ItemDTO;
import com.phantom.inventoryservice.services.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping()
@Slf4j
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<List<ItemDTO>> getAllItems() throws InterruptedException {
        log.info("Start getting all items");
        /*Thread.sleep(5000);
        log.info("End sleeping");*/
        List <ItemDTO> all = itemService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
