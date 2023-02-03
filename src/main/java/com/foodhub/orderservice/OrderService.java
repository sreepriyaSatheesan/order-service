package com.foodhub.orderservice;

import com.foodhub.dto.OrderDto;
import com.foodhub.exception.OrderNotFoundException;
import com.foodhub.exception.OrderUpdateException;
import com.foodhub.model.Item;
import com.foodhub.model.Order;
import com.foodhub.model.OrderStatus;
import com.foodhub.orderDetailsRepository.OrderRepository;
import com.foodhub.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private Utility utility;

        @Autowired
        private OrderRepository orderRepository;
    public Order createFoodOrder(OrderDto orderDto) {
        Order order = utility.convertToEntity(orderDto);
        order.setOrderDate(LocalDate.now());
        order.setOrderDateTime(LocalDateTime.now());
        order.setOrderStatus(String.valueOf(OrderStatus.PLACED));
        return orderRepository.save(order);
    }
    private OrderNotFoundException throwException(String value) {
        throw new OrderNotFoundException("Order Not Found with ID: " + value);
    }

    public Order getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> throwException(String.valueOf(orderId)));
        return   order;
    }


    public Order cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> throwException(String.valueOf(orderId)));
           order.setOrderId(orderId);
           order.setCustomerId(order.getCustomerId());
           order.setOrderInstruction(order.getOrderInstruction());
           order.setOrderDateTime(LocalDateTime.now());
           order.setOrderDate(LocalDate.now());
           order.setItems(order.getItems());
           order.setOrderStatus(String.valueOf(OrderStatus.CANCEL));
         return orderRepository.save(order);

    }

    public Order updateOrder(OrderDto orderDto, Long orderId,Long itemId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> throwException(String.valueOf(orderId)));
        String orderStatus = order.getOrderStatus();
        System.out.println("order status DB:"+orderStatus);
        System.out.println("order status  :"+OrderStatus.PLACED);
        if(orderStatus.equals(String.valueOf(OrderStatus.PLACED))){
            order.setOrderId(orderId);
            order.setCustomerId(orderDto.getCustomerId());
            order.setOrderInstruction(orderDto.getOrderInstruction());
            order.setOrderDateTime(LocalDateTime.now());
            order.setOrderDate(LocalDate.now());
            order.setItems(orderDto.getItems());
            order.setOrderStatus(String.valueOf(OrderStatus.PLACED));
            orderRepository.save(order);
        }else{
            throw new OrderUpdateException("Order Could Not Be Updated, Because OF Order Status:"+order.getOrderStatus());
        }

        return order;
    }
}
