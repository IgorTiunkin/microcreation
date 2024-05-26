package com.phantom.inventoryservice.services;

import com.phantom.inventoryservice.dtos.ItemDTO;
import com.phantom.inventoryservice.mappers.ItemMapper;
import com.phantom.inventoryservice.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List <ItemDTO> findAll() {
        return itemMapper.toDTOs(itemRepository.findAll());
    }
}
