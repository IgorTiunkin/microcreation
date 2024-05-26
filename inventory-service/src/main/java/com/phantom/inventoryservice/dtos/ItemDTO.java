package com.phantom.inventoryservice.dtos;

import com.phantom.inventoryservice.models.ItemType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    @ToString.Include
    private Long id;

    @EqualsAndHashCode.Include
    @ToString.Include
    private ItemType itemType;

    @EqualsAndHashCode.Include
    @ToString.Include
    private Long quantity;
}
