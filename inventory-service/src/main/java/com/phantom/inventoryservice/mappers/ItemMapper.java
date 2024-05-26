package com.phantom.inventoryservice.mappers;

import com.phantom.inventoryservice.dtos.ItemDTO;
import com.phantom.inventoryservice.models.Item;
import lombok.NonNull;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface ItemMapper {

    @NonNull
    @Named("toDTO")
    ItemDTO toDTO(@NonNull Item item);

    @NonNull
    @IterableMapping(qualifiedByName = "toDTO")
    List<ItemDTO> toDTOs(@NonNull List<Item> items);



    @NonNull
    @Named("toEntity")
    Item toEntity(@NonNull ItemDTO itemDTO);

    @NonNull
    @IterableMapping(qualifiedByName = "toEntities")
    List <Item> toEntities (@NonNull List <ItemDTO> itemDTOS);

}
