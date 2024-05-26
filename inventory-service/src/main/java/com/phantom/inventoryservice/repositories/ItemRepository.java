package com.phantom.inventoryservice.repositories;

import com.phantom.inventoryservice.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository <Item, Long> {
}
