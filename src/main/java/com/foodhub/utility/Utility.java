package com.foodhub.utility;

import com.foodhub.dto.OrderDto;
import com.foodhub.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Utility {

    private final ModelMapper modelMapper = new ModelMapper();

    public OrderDto convertToDto(Order order) {
        OrderDto orderDto = modelMapper.map(order, OrderDto.class);
        return orderDto;
    }

    public Order convertToEntity(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        return order;
    }
}
