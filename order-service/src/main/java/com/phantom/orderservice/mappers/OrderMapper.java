package com.phantom.orderservice.mappers;

import com.phantom.orderservice.dtos.OrderDTO;
import com.phantom.orderservice.models.Order;
import lombok.NonNull;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface OrderMapper {

    @NonNull
    @Named("toDTO")
    OrderDTO toDTO(@NonNull Order order);

    @NonNull
    @IterableMapping(qualifiedByName = "toDTOs")
    List<OrderDTO> toDTOs(@NonNull List <Order> orderList);

    @NonNull
    @Named("toEntity")
    Order toEntity(@NonNull OrderDTO orderDTO);

    @NonNull
    @IterableMapping(qualifiedByName = "toEntity")
    List <Order> toEntities(@NonNull List <OrderDTO> orderDTOS);

}
